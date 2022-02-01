package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CUploadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CUploadResult;
import com.tencent.mars.cdn.CdnLogic.UploadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.b.n;
import com.tencent.mm.plugin.qqmail.e.c;
import com.tencent.mm.plugin.qqmail.e.d;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.g;
import com.tencent.mm.plugin.qqmail.e.h;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.plugin.qqmail.model.ai;
import com.tencent.mm.plugin.qqmail.model.ao;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
  implements CdnLogic.UploadCallback, com.tencent.mm.am.h
{
  private ViewGroup CAj;
  private TextView Nmm;
  private ImageView Nmn;
  private ComposeUI NnH;
  Map<String, ai> NnI;
  private Map<String, com.tencent.mm.plugin.qqmail.d.a> NnJ;
  private Map<String, String> NnK;
  b NnL;
  private View.OnClickListener NnM;
  
  private b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123021);
    this.NnI = new HashMap();
    this.NnJ = new HashMap();
    this.NnK = new HashMap();
    this.NnL = null;
    this.NnM = null;
    this.NnH = paramComposeUI;
    this.CAj = paramViewGroup;
    this.NnM = null;
    this.Nmm = paramTextView;
    this.Nmn = paramImageView;
    gEE();
    com.tencent.mm.kernel.h.baD().mCm.a(11665, this);
    AppMethodBeat.o(123021);
  }
  
  public b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup, byte paramByte)
  {
    this(paramComposeUI, paramTextView, paramImageView, paramViewGroup);
  }
  
  private void b(ai paramai)
  {
    AppMethodBeat.i(123034);
    int i = Math.abs(paramai.path.hashCode() / 2);
    Object localObject = (LinearLayout)this.CAj.findViewById(i);
    if (localObject == null)
    {
      AppMethodBeat.o(123034);
      return;
    }
    localObject = (a)((LinearLayout)localObject).getTag();
    Log.i("MicroMsg.Mail.FileUploadHelper", "show upload status %d", new Object[] { Integer.valueOf(paramai.state) });
    switch (paramai.state)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).pUL.setTextColor(this.NnH.getResources().getColor(e.c.normal_text_color));
      ((a)localObject).uploadingPB.setVisibility(0);
      ((a)localObject).NnU.setVisibility(8);
      ((a)localObject).NnV.setVisibility(8);
      ((a)localObject).NnW.setVisibility(0);
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).pUL.setTextColor(this.NnH.getResources().getColor(e.c.normal_text_color));
      ((a)localObject).uploadingPB.setVisibility(8);
      ((a)localObject).NnU.setVisibility(8);
      ((a)localObject).NnV.setVisibility(8);
      ((a)localObject).NnW.setVisibility(0);
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).pUL.setTextColor(com.tencent.mm.cd.a.w(this.NnH, e.c.lightgrey));
      ((a)localObject).uploadingPB.setVisibility(8);
      ((a)localObject).NnU.setVisibility(0);
      ((a)localObject).NnV.setVisibility(0);
      ((a)localObject).NnW.setVisibility(0);
    }
  }
  
  public final boolean Te(String paramString)
  {
    AppMethodBeat.i(123024);
    boolean bool = this.NnI.containsKey(paramString);
    AppMethodBeat.o(123024);
    return bool;
  }
  
  final void a(final ai paramai)
  {
    AppMethodBeat.i(123025);
    final LinearLayout localLinearLayout = (LinearLayout)((ViewGroup)View.inflate(this.NnH, e.f.qqmail_comm_widget, null)).findViewById(e.e.plugin_qqmail_compose_attach_item_ll);
    ImageView localImageView1 = (ImageView)localLinearLayout.findViewById(e.e.plugin_qqmail_compose_attach_item_icon_iv);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(e.e.plugin_qqmail_compose_attach_item_name_tv);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(e.e.plugin_qqmail_compose_attach_item_size_tv);
    ProgressBar localProgressBar = (ProgressBar)localLinearLayout.findViewById(e.e.plugin_qqmail_compose_attach_item_uploading_pb);
    TextView localTextView3 = (TextView)localLinearLayout.findViewById(e.e.plugin_qqmail_compose_attach_upload_failed_tv);
    ImageView localImageView2 = (ImageView)localLinearLayout.findViewById(e.e.plugin_qqmail_compose_attach_item_reupload_iv);
    ImageView localImageView3 = (ImageView)localLinearLayout.findViewById(e.e.plugin_qqmail_compose_attach_item_delete_iv);
    ((ViewGroup)localLinearLayout.getParent()).removeView(localLinearLayout);
    localImageView1.setImageResource(FileExplorerUI.brA(paramai.name));
    localTextView1.setText(paramai.name);
    localTextView2.setText(Util.getSizeKB(paramai.size));
    a locala = new a((byte)0);
    locala.ttT = localImageView1;
    locala.pUL = localTextView1;
    locala.Nnr = localTextView2;
    locala.uploadingPB = localProgressBar;
    locala.NnU = localTextView3;
    locala.NnV = localImageView2;
    locala.NnW = localImageView3;
    localLinearLayout.setTag(locala);
    localLinearLayout.setId(Math.abs(paramai.path.hashCode() / 2));
    if (this.NnM != null) {
      localLinearLayout.setOnClickListener(this.NnM);
    }
    this.CAj.addView(localLinearLayout);
    gEE();
    localLinearLayout.setOnClickListener(new b.1(this, localImageView2));
    localImageView2.setOnClickListener(new b.2(this, paramai));
    localImageView3.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123011);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        k.a(b.a(b.this), e.i.plugin_qqmail_attachment_delete_confirm, e.i.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(123010);
            if ((b.3.this.NnP.state == 0) || (b.3.this.NnP.state == 1)) {
              b.a(b.this, b.3.this.NnP);
            }
            b.b(b.this).remove(b.3.this.NnP.path);
            b.c(b.this).remove(b.3.this.NnP.path);
            b.d(b.this).removeView(b.3.this.NnQ);
            b.this.gEE();
            AppMethodBeat.o(123010);
          }
        }, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123011);
      }
    });
    this.CAj.post(new b.4(this, paramai));
    if (paramai.state == 0) {
      paramai.Bjl = aSs(paramai.path);
    }
    AppMethodBeat.o(123025);
  }
  
  final long aSs(String paramString)
  {
    AppMethodBeat.i(123029);
    try
    {
      Object localObject1 = new u(paramString);
      Log.i("MicroMsg.Mail.FileUploadHelper", "doNormalUpload %s", new Object[] { paramString, ((u)localObject1).getName() });
      Object localObject2 = y.bi(paramString, 0, (int)((u)localObject1).length());
      String str = n.W((byte[])localObject2);
      localObject2 = MD5Util.getMD5String((byte[])localObject2);
      localObject1 = new com.tencent.mm.plugin.qqmail.d.a(paramString, (int)((u)localObject1).length(), str, (String)localObject2);
      com.tencent.mm.kernel.h.aZW().a((p)localObject1, 0);
      this.NnJ.put(paramString, localObject1);
      long l = System.currentTimeMillis();
      AppMethodBeat.o(123029);
      return l;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Mail.FileUploadHelper", paramString, "", new Object[0]);
      }
    }
  }
  
  public final LinkedList<ai> gEB()
  {
    AppMethodBeat.i(123027);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.NnI.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add((ai)this.NnI.get(str));
    }
    AppMethodBeat.o(123027);
    return localLinkedList;
  }
  
  public final void gEC()
  {
    AppMethodBeat.i(123028);
    Iterator localIterator = this.NnI.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ai)this.NnI.get(localObject);
      if (((ai)localObject).state != 2)
      {
        com.tencent.mm.plugin.qqmail.d.a locala = (com.tencent.mm.plugin.qqmail.d.a)this.NnJ.get(((ai)localObject).path);
        if (locala != null)
        {
          com.tencent.mm.kernel.h.baD().mCm.a(locala);
          ((ai)localObject).state = 3;
          b((ai)localObject);
          this.NnJ.remove(((ai)localObject).path);
        }
      }
    }
    AppMethodBeat.o(123028);
  }
  
  public final boolean gED()
  {
    AppMethodBeat.i(123031);
    Iterator localIterator = this.NnI.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ai)this.NnI.get(localObject);
      if ((((ai)localObject).state != 2) && (((ai)localObject).state != 3))
      {
        AppMethodBeat.o(123031);
        return false;
      }
    }
    AppMethodBeat.o(123031);
    return true;
  }
  
  public final void gEE()
  {
    AppMethodBeat.i(123032);
    int j;
    int i;
    if (this.NnI.size() == 0)
    {
      this.Nmm.setText(this.NnH.getString(e.i.plugin_qqmail_composeui_attach) + " " + this.NnH.getString(e.i.plugin_qqmail_composeui_attach_hint));
      this.Nmn.setImageResource(e.h.qqmail_attach_icon_normal);
      ((View)this.CAj.getParent()).setVisibility(8);
      j = this.CAj.getChildCount();
      i = 0;
      label102:
      if (i >= j) {
        break label311;
      }
      if (j != 1) {
        break label245;
      }
      this.CAj.getChildAt(i).setBackgroundResource(e.d.mail_attach_list_item);
    }
    for (;;)
    {
      i += 1;
      break label102;
      this.Nmm.setText(this.NnH.getString(e.i.plugin_qqmail_composeui_attach) + this.NnH.getResources().getQuantityString(e.g.plugin_qqmail_composeui_attach_summary, this.NnI.size(), new Object[] { Integer.valueOf(this.NnI.size()), Util.getSizeKB(getTotalSize()) }));
      this.Nmn.setImageResource(e.h.qqmail_attach_icon_pressed);
      ((View)this.CAj.getParent()).setVisibility(0);
      break;
      label245:
      if (i == 0) {
        this.CAj.getChildAt(i).setBackgroundResource(e.d.mail_attach_list_item1);
      } else if ((i > 0) && (i < j - 1)) {
        this.CAj.getChildAt(i).setBackgroundResource(e.d.mail_attach_list_item2);
      } else {
        this.CAj.getChildAt(i).setBackgroundResource(e.d.mail_attach_list_item3);
      }
    }
    label311:
    AppMethodBeat.o(123032);
  }
  
  public final int getTotalSize()
  {
    AppMethodBeat.i(123033);
    Iterator localIterator = this.NnI.keySet().iterator();
    String str;
    long l;
    for (int i = 0; localIterator.hasNext(); i = (int)(((ai)this.NnI.get(str)).size + l))
    {
      str = (String)localIterator.next();
      l = i;
    }
    AppMethodBeat.o(123033);
    return i;
  }
  
  public final void jB(List<ai> paramList)
  {
    AppMethodBeat.i(266949);
    if (paramList == null)
    {
      AppMethodBeat.o(266949);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ai localai = (ai)paramList.next();
      this.NnI.put(localai.path, localai);
      a(localai);
    }
    AppMethodBeat.o(266949);
  }
  
  public final void onC2CUploadCompleted(String paramString, CdnLogic.C2CUploadResult paramC2CUploadResult)
  {
    AppMethodBeat.i(266962);
    Log.i("MicroMsg.Mail.FileUploadHelper", "onC2CUploadCompleted %s", new Object[] { paramString });
    if (this.NnK.containsKey(paramString)) {
      MMHandlerThread.postToMainThread(new b.5(this, (ai)this.NnI.get(this.NnK.get(paramString)), paramC2CUploadResult));
    }
    AppMethodBeat.o(266962);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(123035);
    if (paramp.getType() == 11665)
    {
      String str = ((com.tencent.mm.plugin.qqmail.d.a)paramp).filePath;
      Log.i("MicroMsg.Mail.FileUploadHelper", "errType %d, errCode %d, errMsg %s, filePath %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str });
      paramString = (ai)this.NnI.get(str);
      this.NnJ.remove(str);
      if (paramString != null)
      {
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          paramString.state = 3;
          b(paramString);
          AppMethodBeat.o(123035);
          return;
        }
        CdnLogic.C2CUploadRequest localC2CUploadRequest = new CdnLogic.C2CUploadRequest();
        localC2CUploadRequest.fileKey = ((com.tencent.mm.plugin.qqmail.d.a)paramp).obF;
        localC2CUploadRequest.setFilePath(str);
        localC2CUploadRequest.forwardFileid = ((ao)c.c.b(((com.tencent.mm.plugin.qqmail.d.a)paramp).oDw.otC)).Nlm;
        localC2CUploadRequest.host = ((ao)c.c.b(((com.tencent.mm.plugin.qqmail.d.a)paramp).oDw.otC)).Nll;
        this.NnK.put(localC2CUploadRequest.fileKey, str);
        paramString.state = 1;
        paramString.svrId = ((ao)c.c.b(((com.tencent.mm.plugin.qqmail.d.a)paramp).oDw.otC)).fileid;
        b(paramString);
        CdnLogic.startFtnUpload(localC2CUploadRequest, this);
      }
    }
    AppMethodBeat.o(123035);
  }
  
  public final void onUploadProgressChanged(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(266958);
    Log.i("MicroMsg.Mail.FileUploadHelper", "onUploadProgressChanged fileKey:%s finish:%d total:%d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(266958);
  }
  
  final class a
  {
    TextView NnU;
    ImageView NnV;
    ImageView NnW;
    TextView Nnr;
    TextView pUL;
    ImageView ttT;
    ProgressBar uploadingPB;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void gEs();
    
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.b
 * JD-Core Version:    0.7.0.1
 */