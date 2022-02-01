package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class it
  extends com.tencent.mm.bw.a
{
  public LinkedList<ahf> FUf;
  public String FUg;
  public String FUh;
  public String dlT;
  public String uVs;
  public String yhW;
  public int yhX;
  public int yhY;
  public String yhZ;
  public String yia;
  public String yib;
  public long yie;
  
  public it()
  {
    AppMethodBeat.i(72420);
    this.FUf = new LinkedList();
    AppMethodBeat.o(72420);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlT != null) {
        paramVarArgs.d(1, this.dlT);
      }
      if (this.uVs != null) {
        paramVarArgs.d(2, this.uVs);
      }
      if (this.yhW != null) {
        paramVarArgs.d(3, this.yhW);
      }
      paramVarArgs.aS(4, this.yhX);
      paramVarArgs.aS(5, this.yhY);
      paramVarArgs.e(6, 8, this.FUf);
      if (this.yhZ != null) {
        paramVarArgs.d(7, this.yhZ);
      }
      if (this.yia != null) {
        paramVarArgs.d(8, this.yia);
      }
      if (this.yib != null) {
        paramVarArgs.d(9, this.yib);
      }
      if (this.FUg != null) {
        paramVarArgs.d(10, this.FUg);
      }
      if (this.FUh != null) {
        paramVarArgs.d(11, this.FUh);
      }
      paramVarArgs.aZ(12, this.yie);
      AppMethodBeat.o(72421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlT == null) {
        break label918;
      }
    }
    label918:
    for (int i = f.a.a.b.b.a.e(1, this.dlT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uVs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uVs);
      }
      i = paramInt;
      if (this.yhW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.yhW);
      }
      i = i + f.a.a.b.b.a.bz(4, this.yhX) + f.a.a.b.b.a.bz(5, this.yhY) + f.a.a.a.c(6, 8, this.FUf);
      paramInt = i;
      if (this.yhZ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.yhZ);
      }
      i = paramInt;
      if (this.yia != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.yia);
      }
      paramInt = i;
      if (this.yib != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.yib);
      }
      i = paramInt;
      if (this.FUg != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FUg);
      }
      paramInt = i;
      if (this.FUh != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FUh);
      }
      i = f.a.a.b.b.a.p(12, this.yie);
      AppMethodBeat.o(72421);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FUf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        it localit = (it)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72421);
          return -1;
        case 1: 
          localit.dlT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 2: 
          localit.uVs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 3: 
          localit.yhW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 4: 
          localit.yhX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72421);
          return 0;
        case 5: 
          localit.yhY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72421);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ahf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localit.FUf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72421);
          return 0;
        case 7: 
          localit.yhZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 8: 
          localit.yia = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 9: 
          localit.yib = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 10: 
          localit.FUg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 11: 
          localit.FUh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72421);
          return 0;
        }
        localit.yie = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(72421);
        return 0;
      }
      AppMethodBeat.o(72421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.it
 * JD-Core Version:    0.7.0.1
 */