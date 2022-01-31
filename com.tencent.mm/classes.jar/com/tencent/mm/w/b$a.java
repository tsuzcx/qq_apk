package com.tencent.mm.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.a;

final class b$a
{
  String blZ;
  String czF;
  String ezj;
  String ezk;
  String ezl;
  String ezm;
  String ezn;
  long id;
  int status;
  int type;
  String userName;
  
  b$a() {}
  
  b$a(a parama)
  {
    AppMethodBeat.i(124475);
    this.id = a.wV(parama.Al());
    this.ezj = parama.apZ();
    this.ezk = parama.aqb();
    this.ezl = parama.aqa();
    this.blZ = parama.aqc();
    this.ezm = parama.aqe();
    this.ezn = parama.aqd();
    this.userName = parama.getUsername();
    this.czF = parama.aqf();
    this.type = parama.type;
    this.status = parama.status;
    AppMethodBeat.o(124475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.w.b.a
 * JD-Core Version:    0.7.0.1
 */