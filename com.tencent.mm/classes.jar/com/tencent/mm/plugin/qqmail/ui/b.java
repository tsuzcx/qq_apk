package com.tencent.mm.plugin.qqmail.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.ah;
import com.tencent.mm.plugin.qqmail.b.ai;
import com.tencent.mm.plugin.qqmail.b.u;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.plugin.qqmail.b.v.c;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
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
  int mode;
  private TextView pLp;
  private ImageView pLq;
  ComposeUI pMN;
  ViewGroup pMO;
  Map<String, ai> pMP;
  Map<String, u> pMQ;
  Map<String, String> pMR;
  Map<String, String> pMS;
  b.b pMT;
  private View.OnClickListener pMU;
  
  private b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(68295);
    this.pMP = new HashMap();
    this.pMQ = new HashMap();
    this.pMR = new LinkedHashMap();
    this.pMS = new LinkedHashMap();
    this.pMT = null;
    this.pMU = null;
    this.mode = 5;
    this.pMN = paramComposeUI;
    this.pMO = paramViewGroup;
    this.pMU = null;
    this.pLp = paramTextView;
    this.pLq = paramImageView;
    ceq();
    com.tencent.mm.kernel.g.RK().eHt.a(484, this);
    AppMethodBeat.o(68295);
  }
  
  public b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup, byte paramByte)
  {
    this(paramComposeUI, paramTextView, paramImageView, paramViewGroup);
  }
  
  private void a(final ai paramai)
  {
    AppMethodBeat.i(68299);
    LinearLayout localLinearLayout = (LinearLayout)((ViewGroup)View.inflate(this.pMN, 2130970483, null)).findViewById(2131826892);
    ImageView localImageView1 = (ImageView)localLinearLayout.findViewById(2131826893);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131826894);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131826895);
    ProgressBar localProgressBar = (ProgressBar)localLinearLayout.findViewById(2131826896);
    TextView localTextView3 = (TextView)localLinearLayout.findViewById(2131826897);
    ImageView localImageView2 = (ImageView)localLinearLayout.findViewById(2131826898);
    ImageView localImageView3 = (ImageView)localLinearLayout.findViewById(2131826899);
    ((ViewGroup)localLinearLayout.getParent()).removeView(localLinearLayout);
    localImageView1.setImageResource(FileExplorerUI.amF(paramai.name));
    localTextView1.setText(paramai.name);
    localTextView2.setText(bo.hk(paramai.size));
    b.a locala = new b.a(this, (byte)0);
    locala.ivs = localImageView1;
    locala.gzk = localTextView1;
    locala.pMw = localTextView2;
    locala.pNd = localProgressBar;
    locala.pNe = localTextView3;
    locala.pNf = localImageView2;
    locala.pNg = localImageView3;
    localLinearLayout.setTag(locala);
    localLinearLayout.setId(Math.abs(paramai.path.hashCode() / 2));
    if (this.pMU != null) {
      localLinearLayout.setOnClickListener(this.pMU);
    }
    this.pMO.addView(localLinearLayout);
    ceq();
    localLinearLayout.setOnClickListener(new b.1(this, localImageView2));
    localImageView2.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68283);
        long l;
        if (b.this.mode == 5)
        {
          l = b.this.XB(paramai.path);
          paramai.pKF = l;
          AppMethodBeat.o(68283);
          return;
        }
        if (b.this.mode == 6)
        {
          l = b.this.fP(paramai.path, paramai.name);
          paramai.pKF = l;
        }
        AppMethodBeat.o(68283);
      }
    });
    localImageView3.setOnClickListener(new b.3(this, paramai, localLinearLayout));
    this.pMO.post(new b.4(this, paramai));
    if (paramai.state == 0)
    {
      if (this.mode == 5)
      {
        paramai.pKF = XB(paramai.path);
        AppMethodBeat.o(68299);
        return;
      }
      if (this.mode == 6) {
        paramai.pKF = fP(paramai.path, paramai.name);
      }
    }
    AppMethodBeat.o(68299);
  }
  
  final long XB(final String paramString)
  {
    AppMethodBeat.i(68303);
    v.c localc = new v.c();
    localc.pJO = false;
    localc.pJN = true;
    long l = ac.cdQ().a("/cgi-bin/uploaddata", "UploadFile", paramString, localc, new v.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(68290);
        b.a(b.this);
        AppMethodBeat.o(68290);
      }
      
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(68289);
        ab.e("MicroMsg.FileUploadHelper", "errCode:%d, desc:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        paramAnonymousString = (ai)b.this.pMP.get(paramString);
        if (paramAnonymousString != null)
        {
          paramAnonymousString.state = 3;
          b.this.b(paramAnonymousString);
        }
        if (paramAnonymousInt == -5)
        {
          b.this.pMN.pLx.a(new b.5.1(this));
          AppMethodBeat.o(68289);
          return;
        }
        AppMethodBeat.o(68289);
      }
      
      public final boolean onReady()
      {
        AppMethodBeat.i(68287);
        ai localai = (ai)b.this.pMP.get(paramString);
        if (localai != null)
        {
          localai.state = 1;
          b.this.b(localai);
        }
        AppMethodBeat.o(68287);
        return true;
      }
      
      public final void onSuccess(String paramAnonymousString, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(68288);
        paramAnonymousString = (String)paramAnonymousMap.get(".Response.result.DataID");
        paramAnonymousMap = (ai)b.this.pMP.get(paramString);
        if (paramAnonymousMap != null)
        {
          paramAnonymousMap.state = 2;
          paramAnonymousMap.pKG = paramAnonymousString;
          b.this.b(paramAnonymousMap);
        }
        AppMethodBeat.o(68288);
      }
    });
    AppMethodBeat.o(68303);
    return l;
  }
  
  final void b(ai paramai)
  {
    AppMethodBeat.i(68308);
    int i = Math.abs(paramai.path.hashCode() / 2);
    Object localObject = (LinearLayout)this.pMO.findViewById(i);
    if (localObject == null)
    {
      AppMethodBeat.o(68308);
      return;
    }
    localObject = (b.a)((LinearLayout)localObject).getTag();
    switch (paramai.state)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(68308);
      return;
      ((b.a)localObject).gzk.setTextColor(-16777216);
      ((b.a)localObject).pNd.setVisibility(0);
      ((b.a)localObject).pNe.setVisibility(8);
      ((b.a)localObject).pNf.setVisibility(8);
      ((b.a)localObject).pNg.setVisibility(0);
      AppMethodBeat.o(68308);
      return;
      ((b.a)localObject).gzk.setTextColor(-16777216);
      ((b.a)localObject).pNd.setVisibility(8);
      ((b.a)localObject).pNe.setVisibility(8);
      ((b.a)localObject).pNf.setVisibility(8);
      ((b.a)localObject).pNg.setVisibility(0);
      AppMethodBeat.o(68308);
      return;
      ((b.a)localObject).gzk.setTextColor(a.m(this.pMN, 2131690211));
      ((b.a)localObject).pNd.setVisibility(8);
      ((b.a)localObject).pNe.setVisibility(0);
      ((b.a)localObject).pNf.setVisibility(0);
      ((b.a)localObject).pNg.setVisibility(0);
    }
  }
  
  public final void cE(List<ai> paramList)
  {
    AppMethodBeat.i(68296);
    if (paramList == null)
    {
      AppMethodBeat.o(68296);
      return;
    }
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ai localai = (ai)((Iterator)localObject).next();
      a(localai);
      this.pMP.put(localai.path, localai);
    }
    if (this.mode == 6)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (ai)paramList.next();
        this.pMR.put(((ai)localObject).path, ((ai)localObject).pKG);
        this.pMS.put(((ai)localObject).path, ((ai)localObject).name);
      }
    }
    AppMethodBeat.o(68296);
  }
  
  public final String cem()
  {
    AppMethodBeat.i(68300);
    String str1 = "";
    Iterator localIterator = this.pMP.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      String str2 = str1;
      if (str1.length() > 0) {
        str2 = str1 + "|";
      }
      str1 = str2 + ((ai)this.pMP.get(str3)).pKG;
    }
    AppMethodBeat.o(68300);
    return str1;
  }
  
  public final LinkedList<ai> cen()
  {
    AppMethodBeat.i(68301);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.pMP.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(this.pMP.get(str));
    }
    AppMethodBeat.o(68301);
    return localLinkedList;
  }
  
  public final void ceo()
  {
    AppMethodBeat.i(68302);
    Iterator localIterator;
    Object localObject;
    if (this.mode == 5)
    {
      localIterator = this.pMP.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localObject = (ai)this.pMP.get(localObject);
        if (((ai)localObject).state != 2)
        {
          ac.cdQ().cancel(((ai)localObject).pKF);
          ((ai)localObject).state = 3;
          b((ai)localObject);
        }
      }
      AppMethodBeat.o(68302);
      return;
    }
    if (this.mode == 6)
    {
      localIterator = this.pMP.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localObject = (ai)this.pMP.get(localObject);
        if (((ai)localObject).state != 2)
        {
          u localu = (u)this.pMQ.get(((ai)localObject).path);
          if (localu != null)
          {
            com.tencent.mm.kernel.g.RK().eHt.a(localu);
            ((ai)localObject).state = 3;
            b((ai)localObject);
          }
          this.pMR.remove(((ai)localObject).path);
          this.pMS.remove(((ai)localObject).path);
          this.pMQ.remove(((ai)localObject).path);
        }
      }
    }
    AppMethodBeat.o(68302);
  }
  
  public final boolean cep()
  {
    AppMethodBeat.i(68305);
    Iterator localIterator = this.pMP.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ai)this.pMP.get(localObject);
      if ((((ai)localObject).state != 2) && (((ai)localObject).state != 3))
      {
        AppMethodBeat.o(68305);
        return false;
      }
    }
    AppMethodBeat.o(68305);
    return true;
  }
  
  public final void ceq()
  {
    AppMethodBeat.i(68306);
    int j;
    int i;
    if (this.pMP.size() == 0)
    {
      this.pLp.setText(this.pMN.getString(2131302119) + " " + this.pMN.getString(2131302122));
      this.pLq.setImageResource(2131231889);
      ((View)this.pMO.getParent()).setVisibility(8);
      j = this.pMO.getChildCount();
      i = 0;
      label102:
      if (i >= j) {
        break label311;
      }
      if (j != 1) {
        break label245;
      }
      this.pMO.getChildAt(i).setBackgroundResource(2130839566);
    }
    for (;;)
    {
      i += 1;
      break label102;
      this.pLp.setText(this.pMN.getString(2131302119) + this.pMN.getResources().getQuantityString(2131361816, this.pMP.size(), new Object[] { Integer.valueOf(this.pMP.size()), bo.hk(cer()) }));
      this.pLq.setImageResource(2131231890);
      ((View)this.pMO.getParent()).setVisibility(0);
      break;
      label245:
      if (i == 0) {
        this.pMO.getChildAt(i).setBackgroundResource(2130839567);
      } else if ((i > 0) && (i < j - 1)) {
        this.pMO.getChildAt(i).setBackgroundResource(2130839568);
      } else {
        this.pMO.getChildAt(i).setBackgroundResource(2130839569);
      }
    }
    label311:
    AppMethodBeat.o(68306);
  }
  
  public final int cer()
  {
    AppMethodBeat.i(68307);
    Iterator localIterator = this.pMP.keySet().iterator();
    String str;
    long l;
    for (int i = 0; localIterator.hasNext(); i = (int)(((ai)this.pMP.get(str)).size + l))
    {
      str = (String)localIterator.next();
      l = i;
    }
    AppMethodBeat.o(68307);
    return i;
  }
  
  public final void fO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(68297);
    if ((paramString1 == null) || (paramString1.length() == 0) || (this.pMP.containsKey(paramString1)))
    {
      AppMethodBeat.o(68297);
      return;
    }
    File localFile = new File(paramString1);
    if ((!localFile.exists()) || (!localFile.isFile()))
    {
      AppMethodBeat.o(68297);
      return;
    }
    ai localai = new ai();
    localai.path = paramString1;
    if (paramString2 == null) {}
    for (localai.name = localFile.getName();; localai.name = paramString2)
    {
      localai.size = localFile.length();
      localai.state = 0;
      this.pMP.put(paramString1, localai);
      a(localai);
      AppMethodBeat.o(68297);
      return;
    }
  }
  
  final long fP(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(68304);
    if (this.pMQ.containsKey(paramString1))
    {
      l = ((u)this.pMQ.get(paramString1)).hashCode();
      AppMethodBeat.o(68304);
      return l;
    }
    paramString2 = new u(paramString1, paramString1, new com.tencent.mm.ai.g()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, m paramAnonymousm)
      {
        AppMethodBeat.i(68293);
        ab.i("MicroMsg.FileUploadHelper", "offset: %d, totalLen: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 < paramAnonymousInt2)
        {
          ab.i("MicroMsg.FileUploadHelper", "uploading file: %s, offset: %d, totalLen: %d", new Object[] { paramString1, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          paramAnonymousm = (ai)b.this.pMP.get(paramString1);
          if (paramAnonymousm != null)
          {
            paramAnonymousm.state = 1;
            al.d(new b.6.1(this, paramAnonymousm));
          }
          AppMethodBeat.o(68293);
          return;
        }
        if (paramAnonymousInt1 >= paramAnonymousInt2)
        {
          ai localai = (ai)b.this.pMP.get(paramString1);
          paramAnonymousm = ((u)paramAnonymousm).cdJ().pIF;
          b.this.pMR.put(paramString1, paramAnonymousm);
          b.this.pMS.put(paramString1, paramString2);
          b.this.pMQ.remove(paramString1);
          ab.i("MicroMsg.FileUploadHelper", "finish uploaded file: %s, attachId: %s", new Object[] { paramString1, paramAnonymousm });
          if (localai != null)
          {
            localai.state = 2;
            localai.pKG = paramAnonymousm;
            al.d(new b.6.2(this, localai));
          }
          b.a(b.this);
        }
        AppMethodBeat.o(68293);
      }
    });
    ai localai = (ai)this.pMP.get(paramString1);
    if (localai != null) {
      localai.state = 1;
    }
    b(localai);
    com.tencent.mm.kernel.g.RK().eHt.a(paramString2, 0);
    this.pMQ.put(paramString1, paramString2);
    long l = paramString2.hashCode();
    AppMethodBeat.o(68304);
    return l;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(68309);
    if (paramm.getType() == 484)
    {
      paramString = (u)paramm;
      paramm = paramString.filePath;
      ai localai = (ai)this.pMP.get(paramm);
      if ((localai != null) && ((paramInt1 != 0) || (paramInt2 != 0)))
      {
        ab.e("MicroMsg.FileUploadHelper", "upload error, errType: %d, errCode: %d, file: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramm });
        localai.state = 3;
        this.pMQ.remove(paramm);
        com.tencent.mm.kernel.g.RK().eHt.a(paramString);
        al.d(new b.7(this, localai));
      }
    }
    AppMethodBeat.o(68309);
  }
  
  public final boolean xm(String paramString)
  {
    AppMethodBeat.i(68298);
    boolean bool = this.pMP.containsKey(paramString);
    AppMethodBeat.o(68298);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.b
 * JD-Core Version:    0.7.0.1
 */