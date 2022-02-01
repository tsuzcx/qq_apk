package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfl
  extends dop
{
  public int Llx;
  public long MKf;
  public int MKg;
  public String MKh;
  public int MKo;
  public int MKp;
  public int MKq;
  public String xNG;
  public String xNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32378);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xNH != null) {
        paramVarArgs.e(2, this.xNH);
      }
      if (this.MKh != null) {
        paramVarArgs.e(3, this.MKh);
      }
      paramVarArgs.aM(4, this.Llx);
      paramVarArgs.bb(5, this.MKf);
      paramVarArgs.aM(6, this.MKg);
      if (this.xNG != null) {
        paramVarArgs.e(7, this.xNG);
      }
      paramVarArgs.aM(8, this.MKp);
      paramVarArgs.aM(9, this.MKo);
      paramVarArgs.aM(10, this.MKq);
      AppMethodBeat.o(32378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xNH != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xNH);
      }
      i = paramInt;
      if (this.MKh != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MKh);
      }
      i = i + g.a.a.b.b.a.bu(4, this.Llx) + g.a.a.b.b.a.r(5, this.MKf) + g.a.a.b.b.a.bu(6, this.MKg);
      paramInt = i;
      if (this.xNG != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.xNG);
      }
      i = g.a.a.b.b.a.bu(8, this.MKp);
      int j = g.a.a.b.b.a.bu(9, this.MKo);
      int k = g.a.a.b.b.a.bu(10, this.MKq);
      AppMethodBeat.o(32378);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dfl localdfl = (dfl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32378);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdfl.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32378);
          return 0;
        case 2: 
          localdfl.xNH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 3: 
          localdfl.MKh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 4: 
          localdfl.Llx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32378);
          return 0;
        case 5: 
          localdfl.MKf = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32378);
          return 0;
        case 6: 
          localdfl.MKg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32378);
          return 0;
        case 7: 
          localdfl.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 8: 
          localdfl.MKp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32378);
          return 0;
        case 9: 
          localdfl.MKo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32378);
          return 0;
        }
        localdfl.MKq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32378);
        return 0;
      }
      AppMethodBeat.o(32378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfl
 * JD-Core Version:    0.7.0.1
 */