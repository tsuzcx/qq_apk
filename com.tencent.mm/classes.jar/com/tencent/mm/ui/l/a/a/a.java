package com.tencent.mm.ui.l.a.a;

import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.l.a.e;
import com.tencent.mm.vfs.aa;
import java.util.LinkedList;

public abstract class a
  extends v
{
  e QlN;
  
  public a(e parame)
  {
    super(new LinkedList());
    this.QlN = parame;
    Object localObject = new com.tencent.mm.vfs.o(b.aKJ(), "luggage/" + parame.mAppId);
    parame = this.kTe;
    localObject = aa.z(((com.tencent.mm.vfs.o)localObject).her());
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new z(aa.z(new com.tencent.mm.vfs.o((String)localObject, "files/").her()), "wxfile://"));
    localLinkedList.add(new com.tencent.mm.plugin.appbrand.appstorage.o(aa.z(new com.tencent.mm.vfs.o((String)localObject, "objects/").her()), "default_obfuscation_key", "wxfile://"));
    parame.addAll(localLinkedList);
    this.kTe.add(gWJ());
    Log.i("MicroMsg.MagicEmojiFileSystem", "hy: file system established");
  }
  
  protected abstract q gWJ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.l.a.a.a
 * JD-Core Version:    0.7.0.1
 */