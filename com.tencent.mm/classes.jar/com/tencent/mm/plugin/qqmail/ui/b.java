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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.ap;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
  implements CdnLogic.UploadCallback, f
{
  private TextView xuc;
  private ImageView xud;
  b xvA;
  private View.OnClickListener xvB;
  private ComposeUI xvv;
  private ViewGroup xvw;
  Map<String, com.tencent.mm.plugin.qqmail.d.aj> xvx;
  private Map<String, com.tencent.mm.plugin.qqmail.e.a> xvy;
  private Map<String, String> xvz;
  
  private b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123021);
    this.xvx = new HashMap();
    this.xvy = new HashMap();
    this.xvz = new HashMap();
    this.xvA = null;
    this.xvB = null;
    this.xvv = paramComposeUI;
    this.xvw = paramViewGroup;
    this.xvB = null;
    this.xuc = paramTextView;
    this.xud = paramImageView;
    dGc();
    g.ajQ().gDv.a(11665, this);
    AppMethodBeat.o(123021);
  }
  
  public b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup, byte paramByte)
  {
    this(paramComposeUI, paramTextView, paramImageView, paramViewGroup);
  }
  
  private void b(com.tencent.mm.plugin.qqmail.d.aj paramaj)
  {
    AppMethodBeat.i(123034);
    int i = Math.abs(paramaj.path.hashCode() / 2);
    Object localObject = (LinearLayout)this.xvw.findViewById(i);
    if (localObject == null)
    {
      AppMethodBeat.o(123034);
      return;
    }
    localObject = (a)((LinearLayout)localObject).getTag();
    ae.i("MicroMsg.Mail.FileUploadHelper", "show upload status %d", new Object[] { Integer.valueOf(paramaj.state) });
    switch (paramaj.state)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).jiC.setTextColor(this.xvv.getResources().getColor(2131100711));
      ((a)localObject).xvJ.setVisibility(0);
      ((a)localObject).xvK.setVisibility(8);
      ((a)localObject).xvL.setVisibility(8);
      ((a)localObject).xvM.setVisibility(0);
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).jiC.setTextColor(this.xvv.getResources().getColor(2131100711));
      ((a)localObject).xvJ.setVisibility(8);
      ((a)localObject).xvK.setVisibility(8);
      ((a)localObject).xvL.setVisibility(8);
      ((a)localObject).xvM.setVisibility(0);
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).jiC.setTextColor(com.tencent.mm.cb.a.n(this.xvv, 2131100544));
      ((a)localObject).xvJ.setVisibility(8);
      ((a)localObject).xvK.setVisibility(0);
      ((a)localObject).xvL.setVisibility(0);
      ((a)localObject).xvM.setVisibility(0);
    }
  }
  
  public final boolean Kh(String paramString)
  {
    AppMethodBeat.i(123024);
    boolean bool = this.xvx.containsKey(paramString);
    AppMethodBeat.o(123024);
    return bool;
  }
  
  final void a(final com.tencent.mm.plugin.qqmail.d.aj paramaj)
  {
    AppMethodBeat.i(123025);
    final LinearLayout localLinearLayout = (LinearLayout)((ViewGroup)View.inflate(this.xvv, 2131495156, null)).findViewById(2131303313);
    ImageView localImageView1 = (ImageView)localLinearLayout.findViewById(2131303312);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131303314);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131303316);
    ProgressBar localProgressBar = (ProgressBar)localLinearLayout.findViewById(2131303317);
    TextView localTextView3 = (TextView)localLinearLayout.findViewById(2131303318);
    final ImageView localImageView2 = (ImageView)localLinearLayout.findViewById(2131303315);
    ImageView localImageView3 = (ImageView)localLinearLayout.findViewById(2131303311);
    ((ViewGroup)localLinearLayout.getParent()).removeView(localLinearLayout);
    localImageView1.setImageResource(FileExplorerUI.aOM(paramaj.name));
    localTextView1.setText(paramaj.name);
    localTextView2.setText(bu.sL(paramaj.size));
    a locala = new a((byte)0);
    locala.mdt = localImageView1;
    locala.jiC = localTextView1;
    locala.xvf = localTextView2;
    locala.xvJ = localProgressBar;
    locala.xvK = localTextView3;
    locala.xvL = localImageView2;
    locala.xvM = localImageView3;
    localLinearLayout.setTag(locala);
    localLinearLayout.setId(Math.abs(paramaj.path.hashCode() / 2));
    if (this.xvB != null) {
      localLinearLayout.setOnClickListener(this.xvB);
    }
    this.xvw.addView(localLinearLayout);
    dGc();
    localLinearLayout.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123008);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (localImageView2.getVisibility() == 0) {
          localImageView2.performClick();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123008);
      }
    });
    localImageView2.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123009);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramaj.xsF = b.a(b.this, paramaj.path);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123009);
      }
    });
    localImageView3.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123011);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        h.a(b.a(b.this), 2131761951, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(123010);
            if ((b.3.this.xvE.state == 0) || (b.3.this.xvE.state == 1)) {
              b.a(b.this, b.3.this.xvE);
            }
            b.b(b.this).remove(b.3.this.xvE.path);
            b.c(b.this).remove(b.3.this.xvE.path);
            b.d(b.this).removeView(b.3.this.xvF);
            b.this.dGc();
            AppMethodBeat.o(123010);
          }
        }, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123011);
      }
    });
    this.xvw.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123012);
        b.b(b.this, paramaj);
        AppMethodBeat.o(123012);
      }
    });
    if (paramaj.state == 0) {
      paramaj.xsF = awr(paramaj.path);
    }
    AppMethodBeat.o(123025);
  }
  
  final long awr(String paramString)
  {
    AppMethodBeat.i(123029);
    try
    {
      Object localObject1 = new k(paramString);
      ae.i("MicroMsg.Mail.FileUploadHelper", "doNormalUpload %s", new Object[] { paramString, ((k)localObject1).getName() });
      Object localObject2 = o.bb(paramString, 0, (int)((k)localObject1).length());
      String str = com.tencent.mm.b.n.bytesToHex(MessageDigest.getInstance("SHA1").digest((byte[])localObject2));
      localObject2 = com.tencent.mm.sdk.platformtools.aj.B((byte[])localObject2);
      localObject1 = new com.tencent.mm.plugin.qqmail.e.a(paramString, (int)((k)localObject1).length(), str, (String)localObject2);
      g.ajj().a((com.tencent.mm.ak.n)localObject1, 0);
      this.xvy.put(paramString, localObject1);
      long l = System.currentTimeMillis();
      AppMethodBeat.o(123029);
      return l;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Mail.FileUploadHelper", paramString, "", new Object[0]);
      }
    }
  }
  
  public final LinkedList<com.tencent.mm.plugin.qqmail.d.aj> dFZ()
  {
    AppMethodBeat.i(123027);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.xvx.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(this.xvx.get(str));
    }
    AppMethodBeat.o(123027);
    return localLinkedList;
  }
  
  public final void dGa()
  {
    AppMethodBeat.i(123028);
    Iterator localIterator = this.xvx.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (com.tencent.mm.plugin.qqmail.d.aj)this.xvx.get(localObject);
      if (((com.tencent.mm.plugin.qqmail.d.aj)localObject).state != 2)
      {
        com.tencent.mm.plugin.qqmail.e.a locala = (com.tencent.mm.plugin.qqmail.e.a)this.xvy.get(((com.tencent.mm.plugin.qqmail.d.aj)localObject).path);
        if (locala != null)
        {
          g.ajQ().gDv.a(locala);
          ((com.tencent.mm.plugin.qqmail.d.aj)localObject).state = 3;
          b((com.tencent.mm.plugin.qqmail.d.aj)localObject);
          this.xvy.remove(((com.tencent.mm.plugin.qqmail.d.aj)localObject).path);
        }
      }
    }
    AppMethodBeat.o(123028);
  }
  
  public final boolean dGb()
  {
    AppMethodBeat.i(123031);
    Iterator localIterator = this.xvx.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (com.tencent.mm.plugin.qqmail.d.aj)this.xvx.get(localObject);
      if ((((com.tencent.mm.plugin.qqmail.d.aj)localObject).state != 2) && (((com.tencent.mm.plugin.qqmail.d.aj)localObject).state != 3))
      {
        AppMethodBeat.o(123031);
        return false;
      }
    }
    AppMethodBeat.o(123031);
    return true;
  }
  
  public final void dGc()
  {
    AppMethodBeat.i(123032);
    int j;
    int i;
    if (this.xvx.size() == 0)
    {
      this.xuc.setText(this.xvv.getString(2131761958) + " " + this.xvv.getString(2131761961));
      this.xud.setImageResource(2131691058);
      ((View)this.xvw.getParent()).setVisibility(8);
      j = this.xvw.getChildCount();
      i = 0;
      label102:
      if (i >= j) {
        break label311;
      }
      if (j != 1) {
        break label245;
      }
      this.xvw.getChildAt(i).setBackgroundResource(2131233185);
    }
    for (;;)
    {
      i += 1;
      break label102;
      this.xuc.setText(this.xvv.getString(2131761958) + this.xvv.getResources().getQuantityString(2131623962, this.xvx.size(), new Object[] { Integer.valueOf(this.xvx.size()), bu.sL(getTotalSize()) }));
      this.xud.setImageResource(2131691059);
      ((View)this.xvw.getParent()).setVisibility(0);
      break;
      label245:
      if (i == 0) {
        this.xvw.getChildAt(i).setBackgroundResource(2131233186);
      } else if ((i > 0) && (i < j - 1)) {
        this.xvw.getChildAt(i).setBackgroundResource(2131233187);
      } else {
        this.xvw.getChildAt(i).setBackgroundResource(2131233188);
      }
    }
    label311:
    AppMethodBeat.o(123032);
  }
  
  public final void fb(List<com.tencent.mm.plugin.qqmail.d.aj> paramList)
  {
    AppMethodBeat.i(218053);
    if (paramList == null)
    {
      AppMethodBeat.o(218053);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.qqmail.d.aj localaj = (com.tencent.mm.plugin.qqmail.d.aj)paramList.next();
      this.xvx.put(localaj.path, localaj);
      a(localaj);
    }
    AppMethodBeat.o(218053);
  }
  
  public final int getTotalSize()
  {
    AppMethodBeat.i(123033);
    Iterator localIterator = this.xvx.keySet().iterator();
    String str;
    long l;
    for (int i = 0; localIterator.hasNext(); i = (int)(((com.tencent.mm.plugin.qqmail.d.aj)this.xvx.get(str)).size + l))
    {
      str = (String)localIterator.next();
      l = i;
    }
    AppMethodBeat.o(123033);
    return i;
  }
  
  public final void onC2CUploadCompleted(String paramString, final CdnLogic.C2CUploadResult paramC2CUploadResult)
  {
    AppMethodBeat.i(218055);
    ae.i("MicroMsg.Mail.FileUploadHelper", "onC2CUploadCompleted %s", new Object[] { paramString });
    if (this.xvz.containsKey(paramString)) {
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(218052);
          if (this.xvH != null)
          {
            if (paramC2CUploadResult.errorCode == 0) {
              break label47;
            }
            this.xvH.state = 3;
          }
          for (;;)
          {
            b.b(b.this, this.xvH);
            AppMethodBeat.o(218052);
            return;
            label47:
            this.xvH.state = 2;
            b.e(b.this);
          }
        }
      });
    }
    AppMethodBeat.o(218055);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(123035);
    if (paramn.getType() == 11665)
    {
      String str = ((com.tencent.mm.plugin.qqmail.e.a)paramn).filePath;
      ae.i("MicroMsg.Mail.FileUploadHelper", "errType %d, errCode %d, errMsg %s, filePath %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str });
      paramString = (com.tencent.mm.plugin.qqmail.d.aj)this.xvx.get(str);
      this.xvy.remove(str);
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
        localC2CUploadRequest.fileKey = ((com.tencent.mm.plugin.qqmail.e.a)paramn).xtt;
        localC2CUploadRequest.setFilePath(str);
        localC2CUploadRequest.forwardFileid = ((ap)((com.tencent.mm.plugin.qqmail.e.a)paramn).hZD.hQE.hQJ).xtb;
        localC2CUploadRequest.host = ((ap)((com.tencent.mm.plugin.qqmail.e.a)paramn).hZD.hQE.hQJ).xta;
        this.xvz.put(localC2CUploadRequest.fileKey, str);
        paramString.state = 1;
        paramString.uPr = ((ap)((com.tencent.mm.plugin.qqmail.e.a)paramn).hZD.hQE.hQJ).fileid;
        b(paramString);
        CdnLogic.startFtnUpload(localC2CUploadRequest, this);
      }
    }
    AppMethodBeat.o(123035);
  }
  
  public final void onUploadProgressChanged(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(218054);
    ae.i("MicroMsg.Mail.FileUploadHelper", "onUploadProgressChanged fileKey:%s finish:%d total:%d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(218054);
  }
  
  final class a
  {
    TextView jiC;
    ImageView mdt;
    ProgressBar xvJ;
    TextView xvK;
    ImageView xvL;
    ImageView xvM;
    TextView xvf;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void dFS();
    
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.b
 * JD-Core Version:    0.7.0.1
 */