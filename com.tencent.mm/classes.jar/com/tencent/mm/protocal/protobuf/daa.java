package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class daa
  extends com.tencent.mm.bx.a
{
  public String aeskey;
  public String fileid;
  public String filemd5;
  public int lAT;
  public int lAU;
  public String lAV;
  public String lAW;
  public String lAX;
  public int lAY;
  public int lAZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260151);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.fileid != null) {
        paramVarArgs.g(1, this.fileid);
      }
      if (this.aeskey != null) {
        paramVarArgs.g(2, this.aeskey);
      }
      if (this.filemd5 != null) {
        paramVarArgs.g(3, this.filemd5);
      }
      paramVarArgs.bS(4, this.lAT);
      paramVarArgs.bS(5, this.lAU);
      if (this.lAV != null) {
        paramVarArgs.g(6, this.lAV);
      }
      if (this.lAW != null) {
        paramVarArgs.g(7, this.lAW);
      }
      if (this.lAX != null) {
        paramVarArgs.g(8, this.lAX);
      }
      paramVarArgs.bS(9, this.lAY);
      paramVarArgs.bS(10, this.lAZ);
      AppMethodBeat.o(260151);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fileid == null) {
        break label698;
      }
    }
    label698:
    for (int i = i.a.a.b.b.a.h(1, this.fileid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aeskey != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aeskey);
      }
      i = paramInt;
      if (this.filemd5 != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.filemd5);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.lAT) + i.a.a.b.b.a.cJ(5, this.lAU);
      paramInt = i;
      if (this.lAV != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.lAV);
      }
      i = paramInt;
      if (this.lAW != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.lAW);
      }
      paramInt = i;
      if (this.lAX != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.lAX);
      }
      i = i.a.a.b.b.a.cJ(9, this.lAY);
      int j = i.a.a.b.b.a.cJ(10, this.lAZ);
      AppMethodBeat.o(260151);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260151);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        daa localdaa = (daa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260151);
          return -1;
        case 1: 
          localdaa.fileid = locala.ajGk.readString();
          AppMethodBeat.o(260151);
          return 0;
        case 2: 
          localdaa.aeskey = locala.ajGk.readString();
          AppMethodBeat.o(260151);
          return 0;
        case 3: 
          localdaa.filemd5 = locala.ajGk.readString();
          AppMethodBeat.o(260151);
          return 0;
        case 4: 
          localdaa.lAT = locala.ajGk.aar();
          AppMethodBeat.o(260151);
          return 0;
        case 5: 
          localdaa.lAU = locala.ajGk.aar();
          AppMethodBeat.o(260151);
          return 0;
        case 6: 
          localdaa.lAV = locala.ajGk.readString();
          AppMethodBeat.o(260151);
          return 0;
        case 7: 
          localdaa.lAW = locala.ajGk.readString();
          AppMethodBeat.o(260151);
          return 0;
        case 8: 
          localdaa.lAX = locala.ajGk.readString();
          AppMethodBeat.o(260151);
          return 0;
        case 9: 
          localdaa.lAY = locala.ajGk.aar();
          AppMethodBeat.o(260151);
          return 0;
        }
        localdaa.lAZ = locala.ajGk.aar();
        AppMethodBeat.o(260151);
        return 0;
      }
      AppMethodBeat.o(260151);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daa
 * JD-Core Version:    0.7.0.1
 */