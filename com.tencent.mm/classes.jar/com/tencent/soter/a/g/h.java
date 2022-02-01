package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.e;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.c.a;
import com.tencent.soter.a.f.c.b;
import com.tencent.soter.a.f.f.a;
import com.tencent.soter.a.f.f.b;
import com.tencent.soter.core.a.a.b;
import com.tencent.soter.core.a.a.d;
import com.tencent.soter.core.c.j;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.lang.ref.WeakReference;
import java.security.Signature;
import junit.framework.Assert;

@Deprecated
public final class h
  extends d
  implements a
{
  String IwV;
  private WeakReference<Context> OKT;
  String RQC;
  private c RRo;
  com.tencent.soter.a.f.f RRp;
  com.tencent.soter.a.d.a RRq;
  com.tencent.soter.a.d.b RRr;
  j RRs;
  private a RRt;
  boolean RRu;
  boolean RRv;
  boolean RRw;
  private int mScene;
  
  public h(b paramb)
  {
    AppMethodBeat.i(64);
    this.mScene = -1;
    this.RQC = null;
    this.IwV = null;
    this.RRo = null;
    this.RRp = null;
    this.OKT = null;
    this.RRq = null;
    this.RRr = null;
    this.RRs = null;
    this.RRt = null;
    if ((Build.VERSION.SDK_INT < 23) && (Build.MANUFACTURER.equalsIgnoreCase("vivo")))
    {
      bool1 = true;
      this.RRu = bool1;
      if (Build.VERSION.SDK_INT >= 23) {
        break label133;
      }
    }
    label133:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.RRv = bool1;
      this.RRw = false;
      if (paramb != null) {
        break label138;
      }
      paramb = new IllegalArgumentException("param is null!");
      AppMethodBeat.o(64);
      throw paramb;
      bool1 = false;
      break;
    }
    label138:
    this.mScene = paramb.mScene;
    this.RRo = paramb.RQP;
    this.RRp = paramb.RQQ;
    this.OKT = new WeakReference(paramb.mContext);
    this.RRr = paramb.RQS;
    this.RRq = paramb.wFx;
    this.IwV = paramb.IwV;
    AppMethodBeat.o(64);
  }
  
  @SuppressLint({"NewApi"})
  final void a(Signature paramSignature)
  {
    AppMethodBeat.i(70);
    if (this.RQG)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: already finished. can not authenticate", new Object[0]);
      AppMethodBeat.o(70);
      return;
    }
    Object localObject = (Context)this.OKT.get();
    if (localObject == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
      c(new com.tencent.soter.a.b.a(1011));
      AppMethodBeat.o(70);
      return;
    }
    try
    {
      com.tencent.soter.core.c.d.v("Soter.TaskAuthentication", "soter: performing start", new Object[0]);
      localObject = com.tencent.soter.core.a.a.lf((Context)localObject);
      a.d locald = new a.d(paramSignature);
      if (this.RRq != null) {}
      for (paramSignature = this.RRq.NHn;; paramSignature = null)
      {
        ((com.tencent.soter.core.a.a)localObject).a(locald, paramSignature, this.RRt);
        AppMethodBeat.o(70);
        return;
      }
      return;
    }
    catch (Exception paramSignature)
    {
      localObject = paramSignature.getMessage();
      com.tencent.soter.core.c.d.e("Soter.TaskAuthentication", "soter: caused exception when authenticating: %s", new Object[] { localObject });
      com.tencent.soter.core.c.d.a("Soter.TaskAuthentication", paramSignature, "soter: caused exception when authenticating");
      c(new com.tencent.soter.a.b.a(1015, String.format("start authentication failed due to %s", new Object[] { localObject })));
      AppMethodBeat.o(70);
    }
  }
  
  final void b(e parame)
  {
    AppMethodBeat.i(68);
    if (((parame.errCode == 1018) || (parame.errCode == 1007) || (parame.errCode == 1015)) && (com.tencent.soter.a.c.a.a(getClass(), parame)))
    {
      com.tencent.soter.core.c.d.i("Soter.TaskAuthentication", "soter: same error happen too much, delete ask", new Object[0]);
      com.tencent.soter.a.a.hlE();
    }
    AppMethodBeat.o(68);
  }
  
  final void execute()
  {
    AppMethodBeat.i(67);
    if (com.tencent.soter.core.c.g.isNullOrNil(this.IwV))
    {
      com.tencent.soter.core.c.d.i("Soter.TaskAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
      this.RRo.setRequest(new c.a());
      this.RRo.a(new com.tencent.soter.a.f.b() {});
      this.RRo.execute();
      AppMethodBeat.o(67);
      return;
    }
    com.tencent.soter.core.c.d.i("Soter.TaskAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
    hlS();
    AppMethodBeat.o(67);
  }
  
  public final void hlL()
  {
    AppMethodBeat.i(72);
    com.tencent.soter.core.c.d.i("Soter.TaskAuthentication", "soter: called from cancellation signal", new Object[0]);
    if (this.RRt != null) {
      this.RRt.onAuthenticationCancelled();
    }
    AppMethodBeat.o(72);
  }
  
  @SuppressLint({"DefaultLocale", "NewApi"})
  final boolean hlM()
  {
    AppMethodBeat.i(65);
    if (!com.tencent.soter.a.c.b.hlG().isInit())
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: not initialized yet", new Object[0]);
      c(new com.tencent.soter.a.b.a(1008));
      AppMethodBeat.o(65);
      return true;
    }
    if (!com.tencent.soter.a.c.b.hlG().hlC())
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: not support soter", new Object[0]);
      c(new com.tencent.soter.a.b.a(2));
      AppMethodBeat.o(65);
      return true;
    }
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.RQC = ((String)com.tencent.soter.a.c.b.hlG().hlI().get(this.mScene, ""));
      if (!com.tencent.soter.core.c.g.isNullOrNil(this.RQC)) {
        break;
      }
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
      c(new com.tencent.soter.a.b.a(1009, String.format("auth scene %d not initialized in map", new Object[] { Integer.valueOf(this.mScene) })));
      AppMethodBeat.o(65);
      return true;
    }
    if (!com.tencent.soter.core.a.bqh(this.RQC))
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: auth key %s not exists. need re-generate", new Object[] { this.RQC });
      c(new com.tencent.soter.a.b.a(1006, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", new Object[] { Integer.valueOf(this.mScene) })));
      AppMethodBeat.o(65);
      return true;
    }
    if ((this.RRo == null) && (com.tencent.soter.core.c.g.isNullOrNil(this.IwV)))
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: challenge wrapper is null!", new Object[0]);
      c(new com.tencent.soter.a.b.a(1010, "neither get challenge wrapper nor challenge str is found in request parameter"));
      AppMethodBeat.o(65);
      return true;
    }
    Context localContext = (Context)this.OKT.get();
    if (localContext == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: context instance released in preExecute", new Object[0]);
      c(new com.tencent.soter.a.b.a(1011));
      AppMethodBeat.o(65);
      return true;
    }
    if (!com.tencent.soter.core.a.a.lf(localContext).hasEnrolledFingerprints())
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: user has not enrolled any fingerprint in system.", new Object[0]);
      c(new com.tencent.soter.a.b.a(1012));
      AppMethodBeat.o(65);
      return true;
    }
    if (com.tencent.soter.core.a.le(localContext))
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: fingerprint sensor frozen", new Object[0]);
      c(new com.tencent.soter.a.b.a(1021, "Too many failed times"));
      AppMethodBeat.o(65);
      return true;
    }
    if (this.RRq == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
      this.RRq = new com.tencent.soter.a.d.a();
      AppMethodBeat.o(65);
      return false;
    }
    if (this.RRp == null) {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
    }
    AppMethodBeat.o(65);
    return false;
  }
  
  final void hlN()
  {
    AppMethodBeat.i(66);
    if (this.RRq != null) {
      this.RRq.DR(true);
    }
    AppMethodBeat.o(66);
  }
  
  final void hlS()
  {
    AppMethodBeat.i(69);
    if (com.tencent.soter.core.a.hlf() == 1)
    {
      localObject = com.tencent.soter.core.a.nI(this.RQC, this.IwV);
      if (localObject == null)
      {
        com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: error occurred when init sign soterSessionResult is null", new Object[0]);
        c(new com.tencent.soter.a.b.a(1007));
        AppMethodBeat.o(69);
        return;
      }
      if (((SoterSessionResult)localObject).resultCode != 0)
      {
        com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: error occurred when init sign resultCode error", new Object[0]);
        c(new com.tencent.soter.a.b.a(1007));
        AppMethodBeat.o(69);
        return;
      }
      com.tencent.soter.core.c.d.d("Soter.TaskAuthentication", "soter: session is %d", new Object[] { Long.valueOf(((SoterSessionResult)localObject).dDZ) });
      this.RRt = new a(null, (byte)0);
      this.RRt.dDZ = ((SoterSessionResult)localObject).dDZ;
      a(null);
      g.hlR().postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46);
          if (h.this.RRr != null) {
            h.this.RRr.fly();
          }
          AppMethodBeat.o(46);
        }
      });
      AppMethodBeat.o(69);
      return;
    }
    Object localObject = com.tencent.soter.core.a.bqk(this.RQC);
    if (localObject == null)
    {
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: error occurred when init sign", new Object[0]);
      c(new com.tencent.soter.a.b.a(1007));
      AppMethodBeat.o(69);
      return;
    }
    this.RRt = new a((Signature)localObject, (byte)0);
    a((Signature)localObject);
    g.hlR().postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47);
        if (h.this.RRr != null) {
          h.this.RRr.fly();
        }
        AppMethodBeat.o(47);
      }
    });
    AppMethodBeat.o(69);
  }
  
  final void hlT()
  {
    AppMethodBeat.i(71);
    if (this.RRs == null)
    {
      c(new com.tencent.soter.a.b.a(1018, "sign failed even after user authenticated the key."));
      AppMethodBeat.o(71);
      return;
    }
    this.RRp.setRequest(new f.a(this.RRs.signature, this.RRs.RPZ, this.RRs.RPY));
    this.RRp.a(new com.tencent.soter.a.f.b() {});
    this.RRp.execute();
    AppMethodBeat.o(71);
  }
  
  public final boolean isCancelled()
  {
    return this.RRw;
  }
  
  final class a
    extends a.b
  {
    Signature RRy = null;
    long dDZ;
    
    private a(Signature paramSignature)
    {
      this.RRy = paramSignature;
    }
    
    static String aH(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(57);
      if (paramCharSequence == null)
      {
        AppMethodBeat.o(57);
        return "unknown error";
      }
      paramCharSequence = paramCharSequence.toString();
      AppMethodBeat.o(57);
      return paramCharSequence;
    }
    
    @SuppressLint({"NewApi"})
    private void hlU()
    {
      AppMethodBeat.i(63);
      if (h.this.RRv)
      {
        h.this.RRq.DR(false);
        h.this.RRw = true;
      }
      AppMethodBeat.o(63);
    }
    
    public final void fme()
    {
      AppMethodBeat.i(60);
      com.tencent.soter.core.c.d.i("Soter.TaskAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
      g.hlR().aj(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: bipush 51
          //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_0
          //   6: getfield 20	com/tencent/soter/a/g/h$a$3:RRB	Lcom/tencent/soter/a/g/h$a;
          //   9: getfield 38	com/tencent/soter/a/g/h$a:RRx	Lcom/tencent/soter/a/g/h;
          //   12: getfield 42	com/tencent/soter/a/g/h:IwV	Ljava/lang/String;
          //   15: invokestatic 48	com/tencent/soter/core/c/g:isNullOrNil	(Ljava/lang/String;)Z
          //   18: ifne +418 -> 436
          //   21: invokestatic 54	com/tencent/soter/core/a:hlf	()I
          //   24: iconst_1
          //   25: if_icmpne +131 -> 156
          //   28: aload_0
          //   29: getfield 20	com/tencent/soter/a/g/h$a$3:RRB	Lcom/tencent/soter/a/g/h$a;
          //   32: getfield 38	com/tencent/soter/a/g/h$a:RRx	Lcom/tencent/soter/a/g/h;
          //   35: astore_3
          //   36: aload_0
          //   37: getfield 20	com/tencent/soter/a/g/h$a$3:RRB	Lcom/tencent/soter/a/g/h$a;
          //   40: getfield 58	com/tencent/soter/a/g/h$a:dDZ	J
          //   43: lstore_1
          //   44: aload_3
          //   45: lload_1
          //   46: invokestatic 62	com/tencent/soter/core/a:Oz	(J)[B
          //   49: invokestatic 66	com/tencent/soter/core/a:cY	([B)Lcom/tencent/soter/core/c/j;
          //   52: putfield 70	com/tencent/soter/a/g/h:RRs	Lcom/tencent/soter/core/c/j;
          //   55: aload_3
          //   56: getfield 74	com/tencent/soter/a/g/h:RRp	Lcom/tencent/soter/a/f/f;
          //   59: ifnull +13 -> 72
          //   62: aload_3
          //   63: invokevirtual 77	com/tencent/soter/a/g/h:hlT	()V
          //   66: bipush 51
          //   68: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   71: return
          //   72: ldc 82
          //   74: ldc 84
          //   76: iconst_0
          //   77: anewarray 4	java/lang/Object
          //   80: invokestatic 89	com/tencent/soter/core/c/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   83: aload_3
          //   84: new 91	com/tencent/soter/a/b/a
          //   87: dup
          //   88: aload_3
          //   89: getfield 70	com/tencent/soter/a/g/h:RRs	Lcom/tencent/soter/core/c/j;
          //   92: invokespecial 94	com/tencent/soter/a/b/a:<init>	(Lcom/tencent/soter/core/c/j;)V
          //   95: invokevirtual 98	com/tencent/soter/a/g/h:c	(Lcom/tencent/soter/a/b/e;)V
          //   98: bipush 51
          //   100: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   103: return
          //   104: astore 4
          //   106: ldc 82
          //   108: ldc 100
          //   110: iconst_1
          //   111: anewarray 4	java/lang/Object
          //   114: dup
          //   115: iconst_0
          //   116: aload 4
          //   118: invokevirtual 104	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   121: aastore
          //   122: invokestatic 107	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   125: ldc 82
          //   127: aload 4
          //   129: ldc 109
          //   131: invokestatic 112	com/tencent/soter/core/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
          //   134: aload_3
          //   135: new 91	com/tencent/soter/a/b/a
          //   138: dup
          //   139: sipush 1018
          //   142: ldc 114
          //   144: invokespecial 117	com/tencent/soter/a/b/a:<init>	(ILjava/lang/String;)V
          //   147: invokevirtual 98	com/tencent/soter/a/g/h:c	(Lcom/tencent/soter/a/b/e;)V
          //   150: bipush 51
          //   152: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   155: return
          //   156: aload_0
          //   157: getfield 20	com/tencent/soter/a/g/h$a$3:RRB	Lcom/tencent/soter/a/g/h$a;
          //   160: getfield 121	com/tencent/soter/a/g/h$a:RRy	Ljava/security/Signature;
          //   163: aload_0
          //   164: getfield 20	com/tencent/soter/a/g/h$a$3:RRB	Lcom/tencent/soter/a/g/h$a;
          //   167: getfield 38	com/tencent/soter/a/g/h$a:RRx	Lcom/tencent/soter/a/g/h;
          //   170: getfield 42	com/tencent/soter/a/g/h:IwV	Ljava/lang/String;
          //   173: ldc 123
          //   175: invokestatic 129	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
          //   178: invokevirtual 135	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
          //   181: invokevirtual 141	java/security/Signature:update	([B)V
          //   184: aload_0
          //   185: getfield 20	com/tencent/soter/a/g/h$a$3:RRB	Lcom/tencent/soter/a/g/h$a;
          //   188: getfield 38	com/tencent/soter/a/g/h$a:RRx	Lcom/tencent/soter/a/g/h;
          //   191: astore_3
          //   192: aload_0
          //   193: getfield 20	com/tencent/soter/a/g/h$a$3:RRB	Lcom/tencent/soter/a/g/h$a;
          //   196: getfield 121	com/tencent/soter/a/g/h$a:RRy	Ljava/security/Signature;
          //   199: astore 4
          //   201: aload_3
          //   202: aload 4
          //   204: invokevirtual 145	java/security/Signature:sign	()[B
          //   207: invokestatic 66	com/tencent/soter/core/a:cY	([B)Lcom/tencent/soter/core/c/j;
          //   210: putfield 70	com/tencent/soter/a/g/h:RRs	Lcom/tencent/soter/core/c/j;
          //   213: aload_3
          //   214: getfield 74	com/tencent/soter/a/g/h:RRp	Lcom/tencent/soter/a/f/f;
          //   217: ifnull +149 -> 366
          //   220: aload_3
          //   221: invokevirtual 77	com/tencent/soter/a/g/h:hlT	()V
          //   224: bipush 51
          //   226: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   229: return
          //   230: astore 4
          //   232: ldc 82
          //   234: ldc 147
          //   236: iconst_1
          //   237: anewarray 4	java/lang/Object
          //   240: dup
          //   241: iconst_0
          //   242: aload 4
          //   244: invokevirtual 148	java/security/SignatureException:getMessage	()Ljava/lang/String;
          //   247: aastore
          //   248: invokestatic 107	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   251: ldc 82
          //   253: aload 4
          //   255: ldc 109
          //   257: invokestatic 112	com/tencent/soter/core/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
          //   260: aload_3
          //   261: new 91	com/tencent/soter/a/b/a
          //   264: dup
          //   265: sipush 1018
          //   268: ldc 114
          //   270: invokespecial 117	com/tencent/soter/a/b/a:<init>	(ILjava/lang/String;)V
          //   273: invokevirtual 98	com/tencent/soter/a/g/h:c	(Lcom/tencent/soter/a/b/e;)V
          //   276: bipush 51
          //   278: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   281: return
          //   282: astore_3
          //   283: ldc 82
          //   285: ldc 150
          //   287: iconst_0
          //   288: anewarray 4	java/lang/Object
          //   291: invokestatic 107	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   294: ldc 82
          //   296: aload_3
          //   297: ldc 150
          //   299: invokestatic 112	com/tencent/soter/core/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
          //   302: ldc 82
          //   304: ldc 152
          //   306: iconst_1
          //   307: anewarray 4	java/lang/Object
          //   310: dup
          //   311: iconst_0
          //   312: aload_0
          //   313: getfield 20	com/tencent/soter/a/g/h$a$3:RRB	Lcom/tencent/soter/a/g/h$a;
          //   316: getfield 38	com/tencent/soter/a/g/h$a:RRx	Lcom/tencent/soter/a/g/h;
          //   319: getfield 155	com/tencent/soter/a/g/h:RQC	Ljava/lang/String;
          //   322: aastore
          //   323: invokestatic 107	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   326: aload_0
          //   327: getfield 20	com/tencent/soter/a/g/h$a$3:RRB	Lcom/tencent/soter/a/g/h$a;
          //   330: getfield 38	com/tencent/soter/a/g/h$a:RRx	Lcom/tencent/soter/a/g/h;
          //   333: getfield 155	com/tencent/soter/a/g/h:RQC	Ljava/lang/String;
          //   336: iconst_0
          //   337: invokestatic 159	com/tencent/soter/core/a:dE	(Ljava/lang/String;Z)Lcom/tencent/soter/core/c/f;
          //   340: pop
          //   341: aload_0
          //   342: getfield 20	com/tencent/soter/a/g/h$a$3:RRB	Lcom/tencent/soter/a/g/h$a;
          //   345: getfield 38	com/tencent/soter/a/g/h$a:RRx	Lcom/tencent/soter/a/g/h;
          //   348: new 91	com/tencent/soter/a/b/a
          //   351: dup
          //   352: sipush 1027
          //   355: ldc 161
          //   357: invokespecial 117	com/tencent/soter/a/b/a:<init>	(ILjava/lang/String;)V
          //   360: invokevirtual 98	com/tencent/soter/a/g/h:c	(Lcom/tencent/soter/a/b/e;)V
          //   363: goto -179 -> 184
          //   366: ldc 82
          //   368: ldc 84
          //   370: iconst_0
          //   371: anewarray 4	java/lang/Object
          //   374: invokestatic 89	com/tencent/soter/core/c/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   377: aload_3
          //   378: new 91	com/tencent/soter/a/b/a
          //   381: dup
          //   382: aload_3
          //   383: getfield 70	com/tencent/soter/a/g/h:RRs	Lcom/tencent/soter/core/c/j;
          //   386: invokespecial 94	com/tencent/soter/a/b/a:<init>	(Lcom/tencent/soter/core/c/j;)V
          //   389: invokevirtual 98	com/tencent/soter/a/g/h:c	(Lcom/tencent/soter/a/b/e;)V
          //   392: bipush 51
          //   394: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   397: return
          //   398: astore_3
          //   399: ldc 82
          //   401: ldc 163
          //   403: iconst_0
          //   404: anewarray 4	java/lang/Object
          //   407: invokestatic 107	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   410: ldc 82
          //   412: aload_3
          //   413: ldc 165
          //   415: invokestatic 112	com/tencent/soter/core/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
          //   418: aload_0
          //   419: getfield 20	com/tencent/soter/a/g/h$a$3:RRB	Lcom/tencent/soter/a/g/h$a;
          //   422: sipush -1000
          //   425: ldc 167
          //   427: invokevirtual 171	com/tencent/soter/a/g/h$a:onAuthenticationError	(ILjava/lang/CharSequence;)V
          //   430: bipush 51
          //   432: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   435: return
          //   436: ldc 82
          //   438: ldc 173
          //   440: iconst_0
          //   441: anewarray 4	java/lang/Object
          //   444: invokestatic 107	com/tencent/soter/core/c/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   447: aload_0
          //   448: getfield 20	com/tencent/soter/a/g/h$a$3:RRB	Lcom/tencent/soter/a/g/h$a;
          //   451: sipush -1000
          //   454: ldc 175
          //   456: invokevirtual 171	com/tencent/soter/a/g/h$a:onAuthenticationError	(ILjava/lang/CharSequence;)V
          //   459: bipush 51
          //   461: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   464: return
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	465	0	this	3
          //   43	3	1	l	long
          //   35	226	3	localh	h
          //   282	101	3	localSignatureException1	java.security.SignatureException
          //   398	15	3	localException1	Exception
          //   104	24	4	localException2	Exception
          //   199	4	4	localSignature	Signature
          //   230	24	4	localSignatureException2	java.security.SignatureException
          // Exception table:
          //   from	to	target	type
          //   44	71	104	java/lang/Exception
          //   72	98	104	java/lang/Exception
          //   201	229	230	java/security/SignatureException
          //   366	392	230	java/security/SignatureException
          //   156	184	282	java/security/SignatureException
          //   184	201	398	java/lang/Exception
          //   201	229	398	java/lang/Exception
          //   232	276	398	java/lang/Exception
          //   366	392	398	java/lang/Exception
          //   392	397	398	java/lang/Exception
        }
      });
      g.hlR().postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52);
          if (h.this.RRr != null) {
            h.this.RRr.flz();
          }
          AppMethodBeat.o(52);
        }
      });
      hlU();
      AppMethodBeat.o(60);
    }
    
    public final void onAuthenticationCancelled()
    {
      AppMethodBeat.i(62);
      com.tencent.soter.core.c.d.i("Soter.TaskAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
      if (h.this.RRw)
      {
        com.tencent.soter.core.c.d.v("Soter.TaskAuthentication", "soter: during ignore cancel period", new Object[0]);
        AppMethodBeat.o(62);
        return;
      }
      super.onAuthenticationCancelled();
      g.hlR().postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(54);
          if (h.this.RRr != null) {
            h.this.RRr.onAuthenticationCancelled();
          }
          AppMethodBeat.o(54);
        }
      });
      h.this.c(new com.tencent.soter.a.b.a(1020, "user cancelled authentication"));
      hlU();
      AppMethodBeat.o(62);
    }
    
    public final void onAuthenticationError(final int paramInt, final CharSequence paramCharSequence)
    {
      AppMethodBeat.i(58);
      com.tencent.soter.core.c.d.e("Soter.TaskAuthentication", "soter: on authentication fatal error: %d, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
      if (paramInt != 10308)
      {
        g.hlR().postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49);
            if (h.this.RRr != null) {
              h.this.RRr.onAuthenticationError(paramInt, paramCharSequence);
            }
            AppMethodBeat.o(49);
          }
        });
        h.this.c(new com.tencent.soter.a.b.a(1016, aH(paramCharSequence)));
      }
      for (;;)
      {
        hlU();
        AppMethodBeat.o(58);
        return;
        h.this.c(new com.tencent.soter.a.b.a(1021, aH(paramCharSequence)));
      }
    }
    
    public final void onAuthenticationFailed()
    {
      AppMethodBeat.i(61);
      super.onAuthenticationFailed();
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: authentication failed once", new Object[0]);
      g.hlR().postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(53);
          if (h.this.RRr != null) {
            h.this.RRr.onAuthenticationFailed();
          }
          AppMethodBeat.o(53);
        }
      });
      if (h.this.RRu)
      {
        com.tencent.soter.core.c.d.i("Soter.TaskAuthentication", "soter: should compat lower android version logic.", new Object[0]);
        h.this.RRq.DR(false);
        g.hlR().aj(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(55);
            h.this.RRq.hlF();
            AppMethodBeat.o(55);
          }
        });
        g.hlR().m(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(56);
            h.this.a(h.a.this.RRy);
            AppMethodBeat.o(56);
          }
        }, 1000L);
      }
      AppMethodBeat.o(61);
    }
    
    public final void onAuthenticationHelp(final int paramInt, final CharSequence paramCharSequence)
    {
      AppMethodBeat.i(59);
      com.tencent.soter.core.c.d.w("Soter.TaskAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
      g.hlR().postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(50);
          if (h.this.RRr != null) {
            h.this.RRr.onAuthenticationHelp(paramInt, h.a.aH(paramCharSequence));
          }
          AppMethodBeat.o(50);
        }
      });
      AppMethodBeat.o(59);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.h
 * JD-Core Version:    0.7.0.1
 */