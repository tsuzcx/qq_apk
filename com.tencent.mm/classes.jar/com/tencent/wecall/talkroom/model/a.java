package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.c;

public class a
{
  private static a xdn = null;
  private f xdo = null;
  
  public static a cRp()
  {
    if (xdn == null) {}
    try
    {
      if (xdn == null) {
        xdn = new a();
      }
      return xdn;
    }
    finally {}
  }
  
  public static f cRq()
  {
    a locala = cRp();
    if (locala.xdo == null) {}
    try
    {
      if (locala.xdo == null) {
        locala.xdo = new f();
      }
      return locala.xdo;
    }
    finally {}
  }
  
  public static void cRr()
  {
    c.d("MicroMsg.Voip", new Object[] { "registerEvents" });
    cRq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.a
 * JD-Core Version:    0.7.0.1
 */