package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cgj
  extends cvp
{
  public int GZA;
  public int GZv;
  public int GZw;
  public String GZx;
  public String GZy;
  public int GZz;
  public int dlw;
  public String iTH;
  public String iTI;
  public String paA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72539);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      paramVarArgs.aS(4, this.GZv);
      paramVarArgs.aS(5, this.GZw);
      if (this.iTH != null) {
        paramVarArgs.d(6, this.iTH);
      }
      if (this.iTI != null) {
        paramVarArgs.d(7, this.iTI);
      }
      if (this.GZx != null) {
        paramVarArgs.d(8, this.GZx);
      }
      if (this.GZy != null) {
        paramVarArgs.d(9, this.GZy);
      }
      paramVarArgs.aS(10, this.GZz);
      paramVarArgs.aS(11, this.GZA);
      AppMethodBeat.o(72539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GZv) + f.a.a.b.b.a.bz(5, this.GZw);
      paramInt = i;
      if (this.iTH != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iTH);
      }
      i = paramInt;
      if (this.iTI != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.iTI);
      }
      paramInt = i;
      if (this.GZx != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GZx);
      }
      i = paramInt;
      if (this.GZy != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GZy);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.GZz);
      int j = f.a.a.b.b.a.bz(11, this.GZA);
      AppMethodBeat.o(72539);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72539);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgj localcgj = (cgj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72539);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72539);
          return 0;
        case 2: 
          localcgj.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72539);
          return 0;
        case 3: 
          localcgj.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 4: 
          localcgj.GZv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72539);
          return 0;
        case 5: 
          localcgj.GZw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72539);
          return 0;
        case 6: 
          localcgj.iTH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 7: 
          localcgj.iTI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 8: 
          localcgj.GZx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 9: 
          localcgj.GZy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 10: 
          localcgj.GZz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72539);
          return 0;
        }
        localcgj.GZA = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(72539);
        return 0;
      }
      AppMethodBeat.o(72539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgj
 * JD-Core Version:    0.7.0.1
 */