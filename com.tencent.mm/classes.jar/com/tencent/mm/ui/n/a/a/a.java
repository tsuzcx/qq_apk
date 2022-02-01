package com.tencent.mm.ui.n.a.a;

import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.appstorage.ab;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.n.a.e;
import com.tencent.mm.vfs.q;
import java.util.LinkedList;

public abstract class a
  extends x
{
  private e XJB;
  
  public a(e parame)
  {
    super(new LinkedList());
    this.XJB = parame;
    Object localObject = new q(b.aSL(), "luggage/" + parame.mAppId);
    parame = this.nNC;
    localObject = ((q)localObject).bOF();
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new ab(new q((String)localObject, "files/").bOF(), "wxfile://"));
    localLinkedList.add(new p(new q((String)localObject, "objects/").bOF(), "default_obfuscation_key", "wxfile://"));
    parame.addAll(localLinkedList);
    this.nNC.add(hXu());
    Log.i("MicroMsg.MagicEmojiFileSystem", "hy: file system established");
  }
  
  protected final e hXt()
  {
    return this.XJB;
  }
  
  protected abstract r hXu();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.a.a
 * JD-Core Version:    0.7.0.1
 */