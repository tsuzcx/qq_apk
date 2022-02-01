package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlp
  extends com.tencent.mm.bw.a
{
  public String FZa;
  public LinkedList<bto> GeR;
  public int HSR;
  public int HSS;
  public int HST;
  public int HSU;
  public int HSV;
  public int HSW;
  public int HSX;
  public String HSY;
  public String HSZ;
  public int HTa;
  public String Hkk;
  public String Title;
  
  public dlp()
  {
    AppMethodBeat.i(152702);
    this.GeR = new LinkedList();
    AppMethodBeat.o(152702);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152703);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hkk != null) {
        paramVarArgs.d(1, this.Hkk);
      }
      paramVarArgs.aS(2, this.HSR);
      paramVarArgs.aS(3, this.HSS);
      paramVarArgs.aS(4, this.HST);
      paramVarArgs.aS(5, this.HSU);
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      paramVarArgs.e(7, 8, this.GeR);
      paramVarArgs.aS(8, this.HSV);
      if (this.FZa != null) {
        paramVarArgs.d(9, this.FZa);
      }
      paramVarArgs.aS(10, this.HSW);
      paramVarArgs.aS(11, this.HSX);
      if (this.HSY != null) {
        paramVarArgs.d(12, this.HSY);
      }
      if (this.HSZ != null) {
        paramVarArgs.d(13, this.HSZ);
      }
      paramVarArgs.aS(14, this.HTa);
      AppMethodBeat.o(152703);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hkk == null) {
        break label958;
      }
    }
    label958:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hkk) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HSR) + f.a.a.b.b.a.bz(3, this.HSS) + f.a.a.b.b.a.bz(4, this.HST) + f.a.a.b.b.a.bz(5, this.HSU);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Title);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.GeR) + f.a.a.b.b.a.bz(8, this.HSV);
      paramInt = i;
      if (this.FZa != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FZa);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.HSW) + f.a.a.b.b.a.bz(11, this.HSX);
      paramInt = i;
      if (this.HSY != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HSY);
      }
      i = paramInt;
      if (this.HSZ != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.HSZ);
      }
      paramInt = f.a.a.b.b.a.bz(14, this.HTa);
      AppMethodBeat.o(152703);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GeR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152703);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlp localdlp = (dlp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152703);
          return -1;
        case 1: 
          localdlp.Hkk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 2: 
          localdlp.HSR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152703);
          return 0;
        case 3: 
          localdlp.HSS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152703);
          return 0;
        case 4: 
          localdlp.HST = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152703);
          return 0;
        case 5: 
          localdlp.HSU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152703);
          return 0;
        case 6: 
          localdlp.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bto();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bto)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlp.GeR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152703);
          return 0;
        case 8: 
          localdlp.HSV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152703);
          return 0;
        case 9: 
          localdlp.FZa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 10: 
          localdlp.HSW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152703);
          return 0;
        case 11: 
          localdlp.HSX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152703);
          return 0;
        case 12: 
          localdlp.HSY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 13: 
          localdlp.HSZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152703);
          return 0;
        }
        localdlp.HTa = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152703);
        return 0;
      }
      AppMethodBeat.o(152703);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlp
 * JD-Core Version:    0.7.0.1
 */