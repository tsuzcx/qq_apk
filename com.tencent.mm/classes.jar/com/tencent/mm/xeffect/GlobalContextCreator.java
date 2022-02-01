package com.tencent.mm.xeffect;

public class GlobalContextCreator
{
  private static native boolean nCheckCreateGlobalContext(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9);
  
  private static native void nDestroyContext();
  
  private static native boolean nIsContextReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.xeffect.GlobalContextCreator
 * JD-Core Version:    0.7.0.1
 */