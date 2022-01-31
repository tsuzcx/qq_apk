package com.tencent.xweb.xwalk;

final class b$5
  implements Runnable
{
  b$5(b paramb, Object paramObject, String paramString) {}
  
  public final void run()
  {
    if (this.xlK.xlG == null) {
      return;
    }
    XWAppBrandEngine localXWAppBrandEngine = this.xlK.xlG;
    Object localObject = this.xlN;
    String str = this.bjS;
    localXWAppBrandEngine.addJsInterface(localXWAppBrandEngine.mInstance, localObject, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.5
 * JD-Core Version:    0.7.0.1
 */