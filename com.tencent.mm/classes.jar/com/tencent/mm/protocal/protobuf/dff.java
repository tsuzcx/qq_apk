package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dff
  extends dop
{
  public int LsZ;
  public long Lta;
  public long MKf;
  public int MKg;
  public String MKh;
  public long MKi;
  public String xNG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32372);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LsZ);
      paramVarArgs.bb(3, this.Lta);
      if (this.xNG != null) {
        paramVarArgs.e(4, this.xNG);
      }
      paramVarArgs.bb(5, this.MKf);
      paramVarArgs.aM(6, this.MKg);
      if (this.MKh != null) {
        paramVarArgs.e(7, this.MKh);
      }
      paramVarArgs.bb(8, this.MKi);
      AppMethodBeat.o(32372);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta);
      paramInt = i;
      if (this.xNG != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xNG);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.MKf) + g.a.a.b.b.a.bu(6, this.MKg);
      paramInt = i;
      if (this.MKh != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MKh);
      }
      i = g.a.a.b.b.a.r(8, this.MKi);
      AppMethodBeat.o(32372);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32372);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dff localdff = (dff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32372);
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
            localdff.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32372);
          return 0;
        case 2: 
          localdff.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32372);
          return 0;
        case 3: 
          localdff.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32372);
          return 0;
        case 4: 
          localdff.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32372);
          return 0;
        case 5: 
          localdff.MKf = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32372);
          return 0;
        case 6: 
          localdff.MKg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32372);
          return 0;
        case 7: 
          localdff.MKh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32372);
          return 0;
        }
        localdff.MKi = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(32372);
        return 0;
      }
      AppMethodBeat.o(32372);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dff
 * JD-Core Version:    0.7.0.1
 */