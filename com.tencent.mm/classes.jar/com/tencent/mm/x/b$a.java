package com.tencent.mm.x;

import com.tencent.mm.plugin.account.friend.a.a;

final class b$a
{
  String aVr;
  String bSe;
  String dBS;
  String dBT;
  String dBU;
  String dBV;
  String dBW;
  long id;
  int status;
  int type;
  String userName;
  
  b$a() {}
  
  b$a(a parama)
  {
    this.id = a.pF(parama.Wv());
    this.dBS = parama.Wx();
    this.dBT = parama.Wz();
    this.dBU = parama.Wy();
    this.aVr = parama.WA();
    this.dBV = parama.WC();
    this.dBW = parama.WB();
    this.userName = parama.getUsername();
    this.bSe = parama.WD();
    this.type = parama.type;
    this.status = parama.status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.x.b.a
 * JD-Core Version:    0.7.0.1
 */