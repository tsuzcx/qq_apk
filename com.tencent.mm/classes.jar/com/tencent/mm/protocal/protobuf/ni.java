package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ni
  extends com.tencent.mm.bw.a
{
  public String FZG;
  public LinkedList<nj> FZH;
  public int FZI;
  public String FZr;
  public int FZs;
  public String FZv;
  public String FZy;
  public String oIy;
  public int ver;
  
  public ni()
  {
    AppMethodBeat.i(188921);
    this.FZH = new LinkedList();
    AppMethodBeat.o(188921);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZy != null) {
        paramVarArgs.d(1, this.FZy);
      }
      if (this.oIy != null) {
        paramVarArgs.d(2, this.oIy);
      }
      paramVarArgs.aS(3, this.ver);
      if (this.FZr != null) {
        paramVarArgs.d(4, this.FZr);
      }
      if (this.FZG != null) {
        paramVarArgs.d(5, this.FZG);
      }
      paramVarArgs.aS(6, this.FZs);
      if (this.FZv != null) {
        paramVarArgs.d(7, this.FZv);
      }
      paramVarArgs.e(8, 8, this.FZH);
      paramVarArgs.aS(9, this.FZI);
      AppMethodBeat.o(124425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FZy == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = f.a.a.b.b.a.e(1, this.FZy) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oIy != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.oIy);
      }
      i += f.a.a.b.b.a.bz(3, this.ver);
      paramInt = i;
      if (this.FZr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FZr);
      }
      i = paramInt;
      if (this.FZG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FZG);
      }
      i += f.a.a.b.b.a.bz(6, this.FZs);
      paramInt = i;
      if (this.FZv != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FZv);
      }
      i = f.a.a.a.c(8, 8, this.FZH);
      int j = f.a.a.b.b.a.bz(9, this.FZI);
      AppMethodBeat.o(124425);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FZH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ni localni = (ni)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124425);
          return -1;
        case 1: 
          localni.FZy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 2: 
          localni.oIy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 3: 
          localni.ver = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124425);
          return 0;
        case 4: 
          localni.FZr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 5: 
          localni.FZG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 6: 
          localni.FZs = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124425);
          return 0;
        case 7: 
          localni.FZv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((nj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localni.FZH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124425);
          return 0;
        }
        localni.FZI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(124425);
        return 0;
      }
      AppMethodBeat.o(124425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ni
 * JD-Core Version:    0.7.0.1
 */