package com.tencent.mm.plugin.qqmail.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.b.c;
import com.tencent.mm.plugin.qqmail.b.e;
import com.tencent.mm.plugin.qqmail.b.f;
import com.tencent.mm.plugin.qqmail.b.g;
import com.tencent.mm.plugin.qqmail.b.h;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.n.d;
import com.tencent.mm.plugin.qqmail.b.u;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.v.c;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
  implements f
{
  int mode = 5;
  private TextView nga;
  private ImageView ngb;
  ComposeUI nhA;
  ViewGroup nhB;
  Map<String, com.tencent.mm.plugin.qqmail.b.ai> nhC = new HashMap();
  Map<String, u> nhD = new HashMap();
  Map<String, String> nhE = new LinkedHashMap();
  Map<String, String> nhF = new LinkedHashMap();
  b.b nhG = null;
  private View.OnClickListener nhH = null;
  
  private b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup)
  {
    this.nhA = paramComposeUI;
    this.nhB = paramViewGroup;
    this.nhH = null;
    this.nga = paramTextView;
    this.ngb = paramImageView;
    bue();
    g.DO().dJT.a(484, this);
  }
  
  public b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup, byte paramByte)
  {
    this(paramComposeUI, paramTextView, paramImageView, paramViewGroup);
  }
  
  private void a(final com.tencent.mm.plugin.qqmail.b.ai paramai)
  {
    LinearLayout localLinearLayout = (LinearLayout)((ViewGroup)View.inflate(this.nhA, b.g.qqmail_comm_widget, null)).findViewById(b.f.plugin_qqmail_compose_attach_item_ll);
    ImageView localImageView1 = (ImageView)localLinearLayout.findViewById(b.f.plugin_qqmail_compose_attach_item_icon_iv);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(b.f.plugin_qqmail_compose_attach_item_name_tv);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(b.f.plugin_qqmail_compose_attach_item_size_tv);
    ProgressBar localProgressBar = (ProgressBar)localLinearLayout.findViewById(b.f.plugin_qqmail_compose_attach_item_uploading_pb);
    TextView localTextView3 = (TextView)localLinearLayout.findViewById(b.f.plugin_qqmail_compose_attach_upload_failed_tv);
    ImageView localImageView2 = (ImageView)localLinearLayout.findViewById(b.f.plugin_qqmail_compose_attach_item_reupload_iv);
    ImageView localImageView3 = (ImageView)localLinearLayout.findViewById(b.f.plugin_qqmail_compose_attach_item_delete_iv);
    ((ViewGroup)localLinearLayout.getParent()).removeView(localLinearLayout);
    localImageView1.setImageResource(FileExplorerUI.WV(paramai.name));
    localTextView1.setText(paramai.name);
    localTextView2.setText(bk.cm(paramai.size));
    a locala = new a((byte)0);
    locala.gSx = localImageView1;
    locala.fhD = localTextView1;
    locala.nhj = localTextView2;
    locala.nhQ = localProgressBar;
    locala.nhR = localTextView3;
    locala.nhS = localImageView2;
    locala.nhT = localImageView3;
    localLinearLayout.setTag(locala);
    localLinearLayout.setId(Math.abs(paramai.path.hashCode() / 2));
    if (this.nhH != null) {
      localLinearLayout.setOnClickListener(this.nhH);
    }
    this.nhB.addView(localLinearLayout);
    bue();
    localLinearLayout.setOnClickListener(new b.1(this, localImageView2));
    localImageView2.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (b.this.mode == 5)
        {
          l = b.this.Lr(paramai.path);
          paramai.nfq = l;
        }
        while (b.this.mode != 6) {
          return;
        }
        long l = b.this.er(paramai.path, paramai.name);
        paramai.nfq = l;
      }
    });
    localImageView3.setOnClickListener(new b.3(this, paramai, localLinearLayout));
    this.nhB.post(new b.4(this, paramai));
    if (paramai.state == 0)
    {
      if (this.mode != 5) {
        break label346;
      }
      paramai.nfq = Lr(paramai.path);
    }
    label346:
    while (this.mode != 6) {
      return;
    }
    paramai.nfq = er(paramai.path, paramai.name);
  }
  
  final long Lr(String paramString)
  {
    v.c localc = new v.c();
    localc.nez = false;
    localc.ney = true;
    v localv = ac.btF();
    b.5 local5 = new b.5(this, paramString);
    return localv.a("/cgi-bin/uploaddata", 1, null, new n.d("UploadFile", paramString), localc, local5);
  }
  
  final void b(com.tencent.mm.plugin.qqmail.b.ai paramai)
  {
    int i = Math.abs(paramai.path.hashCode() / 2);
    Object localObject = (LinearLayout)this.nhB.findViewById(i);
    if (localObject == null) {
      return;
    }
    localObject = (a)((LinearLayout)localObject).getTag();
    switch (paramai.state)
    {
    default: 
      return;
    case 0: 
    case 1: 
      ((a)localObject).fhD.setTextColor(-16777216);
      ((a)localObject).nhQ.setVisibility(0);
      ((a)localObject).nhR.setVisibility(8);
      ((a)localObject).nhS.setVisibility(8);
      ((a)localObject).nhT.setVisibility(0);
      return;
    case 2: 
      ((a)localObject).fhD.setTextColor(-16777216);
      ((a)localObject).nhQ.setVisibility(8);
      ((a)localObject).nhR.setVisibility(8);
      ((a)localObject).nhS.setVisibility(8);
      ((a)localObject).nhT.setVisibility(0);
      return;
    }
    ((a)localObject).fhD.setTextColor(a.i(this.nhA, b.c.lightgrey));
    ((a)localObject).nhQ.setVisibility(8);
    ((a)localObject).nhR.setVisibility(0);
    ((a)localObject).nhS.setVisibility(0);
    ((a)localObject).nhT.setVisibility(0);
  }
  
  public final String bua()
  {
    String str1 = "";
    Iterator localIterator = this.nhC.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      String str2 = str1;
      if (str1.length() > 0) {
        str2 = str1 + "|";
      }
      str1 = str2 + ((com.tencent.mm.plugin.qqmail.b.ai)this.nhC.get(str3)).nfr;
    }
    return str1;
  }
  
  public final LinkedList<com.tencent.mm.plugin.qqmail.b.ai> bub()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.nhC.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(this.nhC.get(str));
    }
    return localLinkedList;
  }
  
  public final void buc()
  {
    Iterator localIterator;
    Object localObject;
    if (this.mode == 5)
    {
      localIterator = this.nhC.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localObject = (com.tencent.mm.plugin.qqmail.b.ai)this.nhC.get(localObject);
        if (((com.tencent.mm.plugin.qqmail.b.ai)localObject).state != 2)
        {
          ac.btF().cancel(((com.tencent.mm.plugin.qqmail.b.ai)localObject).nfq);
          ((com.tencent.mm.plugin.qqmail.b.ai)localObject).state = 3;
          b((com.tencent.mm.plugin.qqmail.b.ai)localObject);
        }
      }
    }
    if (this.mode == 6)
    {
      localIterator = this.nhC.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localObject = (com.tencent.mm.plugin.qqmail.b.ai)this.nhC.get(localObject);
        if (((com.tencent.mm.plugin.qqmail.b.ai)localObject).state != 2)
        {
          u localu = (u)this.nhD.get(((com.tencent.mm.plugin.qqmail.b.ai)localObject).path);
          if (localu != null)
          {
            g.DO().dJT.c(localu);
            ((com.tencent.mm.plugin.qqmail.b.ai)localObject).state = 3;
            b((com.tencent.mm.plugin.qqmail.b.ai)localObject);
          }
          this.nhE.remove(((com.tencent.mm.plugin.qqmail.b.ai)localObject).path);
          this.nhF.remove(((com.tencent.mm.plugin.qqmail.b.ai)localObject).path);
          this.nhD.remove(((com.tencent.mm.plugin.qqmail.b.ai)localObject).path);
        }
      }
    }
  }
  
  public final boolean bud()
  {
    Iterator localIterator = this.nhC.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (com.tencent.mm.plugin.qqmail.b.ai)this.nhC.get(localObject);
      if ((((com.tencent.mm.plugin.qqmail.b.ai)localObject).state != 2) && (((com.tencent.mm.plugin.qqmail.b.ai)localObject).state != 3)) {
        return false;
      }
    }
    return true;
  }
  
  public final void bue()
  {
    int j;
    int i;
    if (this.nhC.size() == 0)
    {
      this.nga.setText(this.nhA.getString(b.j.plugin_qqmail_composeui_attach) + " " + this.nhA.getString(b.j.plugin_qqmail_composeui_attach_hint));
      this.ngb.setImageResource(b.i.qqmail_attach_icon_normal);
      ((View)this.nhB.getParent()).setVisibility(8);
      j = this.nhB.getChildCount();
      i = 0;
      label96:
      if (i >= j) {
        return;
      }
      if (j != 1) {
        break label239;
      }
      this.nhB.getChildAt(i).setBackgroundResource(b.e.mail_attach_list_item);
    }
    for (;;)
    {
      i += 1;
      break label96;
      this.nga.setText(this.nhA.getString(b.j.plugin_qqmail_composeui_attach) + this.nhA.getResources().getQuantityString(b.h.plugin_qqmail_composeui_attach_summary, this.nhC.size(), new Object[] { Integer.valueOf(this.nhC.size()), bk.cm(buf()) }));
      this.ngb.setImageResource(b.i.qqmail_attach_icon_pressed);
      ((View)this.nhB.getParent()).setVisibility(0);
      break;
      label239:
      if (i == 0) {
        this.nhB.getChildAt(i).setBackgroundResource(b.e.mail_attach_list_item1);
      } else if ((i > 0) && (i < j - 1)) {
        this.nhB.getChildAt(i).setBackgroundResource(b.e.mail_attach_list_item2);
      } else {
        this.nhB.getChildAt(i).setBackgroundResource(b.e.mail_attach_list_item3);
      }
    }
  }
  
  public final int buf()
  {
    Iterator localIterator = this.nhC.keySet().iterator();
    String str;
    long l;
    for (int i = 0; localIterator.hasNext(); i = (int)(((com.tencent.mm.plugin.qqmail.b.ai)this.nhC.get(str)).size + l))
    {
      str = (String)localIterator.next();
      l = i;
    }
    return i;
  }
  
  public final void cc(List<com.tencent.mm.plugin.qqmail.b.ai> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.qqmail.b.ai localai = (com.tencent.mm.plugin.qqmail.b.ai)((Iterator)localObject).next();
        a(localai);
        this.nhC.put(localai.path, localai);
      }
      if (this.mode == 6)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (com.tencent.mm.plugin.qqmail.b.ai)paramList.next();
          this.nhE.put(((com.tencent.mm.plugin.qqmail.b.ai)localObject).path, ((com.tencent.mm.plugin.qqmail.b.ai)localObject).nfr);
          this.nhF.put(((com.tencent.mm.plugin.qqmail.b.ai)localObject).path, ((com.tencent.mm.plugin.qqmail.b.ai)localObject).name);
        }
      }
    }
  }
  
  public final void eq(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (this.nhC.containsKey(paramString1))) {}
    File localFile;
    do
    {
      return;
      localFile = new File(paramString1);
    } while ((!localFile.exists()) || (!localFile.isFile()));
    com.tencent.mm.plugin.qqmail.b.ai localai = new com.tencent.mm.plugin.qqmail.b.ai();
    localai.path = paramString1;
    if (paramString2 == null) {}
    for (localai.name = localFile.getName();; localai.name = paramString2)
    {
      localai.size = localFile.length();
      localai.state = 0;
      this.nhC.put(paramString1, localai);
      a(localai);
      return;
    }
  }
  
  final long er(String paramString1, String paramString2)
  {
    if (this.nhD.containsKey(paramString1)) {
      return ((u)this.nhD.get(paramString1)).hashCode();
    }
    paramString2 = new u(paramString1, paramString1, new b.6(this, paramString1, paramString2));
    com.tencent.mm.plugin.qqmail.b.ai localai = (com.tencent.mm.plugin.qqmail.b.ai)this.nhC.get(paramString1);
    if (localai != null) {
      localai.state = 1;
    }
    b(localai);
    g.DO().dJT.a(paramString2, 0);
    this.nhD.put(paramString1, paramString2);
    return paramString2.hashCode();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() == 484)
    {
      paramString = (u)paramm;
      paramm = paramString.filePath;
      com.tencent.mm.plugin.qqmail.b.ai localai = (com.tencent.mm.plugin.qqmail.b.ai)this.nhC.get(paramm);
      if ((localai != null) && ((paramInt1 != 0) || (paramInt2 != 0)))
      {
        y.e("MicroMsg.FileUploadHelper", "upload error, errType: %d, errCode: %d, file: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramm });
        localai.state = 3;
        this.nhD.remove(paramm);
        g.DO().dJT.c(paramString);
        com.tencent.mm.sdk.platformtools.ai.d(new b.7(this, localai));
      }
    }
  }
  
  private final class a
  {
    TextView fhD;
    ImageView gSx;
    ProgressBar nhQ;
    TextView nhR;
    ImageView nhS;
    ImageView nhT;
    TextView nhj;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.b
 * JD-Core Version:    0.7.0.1
 */