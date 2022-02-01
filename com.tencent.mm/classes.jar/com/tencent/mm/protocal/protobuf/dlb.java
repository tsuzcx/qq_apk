package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlb
  extends com.tencent.mm.bw.a
{
  public String KWw;
  public String Luj;
  public String Luk;
  public String MOI;
  public mr MOX;
  public cdu MOY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212300);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MOX != null)
      {
        paramVarArgs.ni(1, this.MOX.computeSize());
        this.MOX.writeFields(paramVarArgs);
      }
      if (this.MOY != null)
      {
        paramVarArgs.ni(2, this.MOY.computeSize());
        this.MOY.writeFields(paramVarArgs);
      }
      if (this.KWw != null) {
        paramVarArgs.e(3, this.KWw);
      }
      if (this.Luk != null) {
        paramVarArgs.e(4, this.Luk);
      }
      if (this.Luj != null) {
        paramVarArgs.e(5, this.Luj);
      }
      if (this.MOI != null) {
        paramVarArgs.e(6, this.MOI);
      }
      AppMethodBeat.o(212300);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MOX == null) {
        break label706;
      }
    }
    label706:
    for (int i = g.a.a.a.nh(1, this.MOX.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MOY != null) {
        paramInt = i + g.a.a.a.nh(2, this.MOY.computeSize());
      }
      i = paramInt;
      if (this.KWw != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KWw);
      }
      paramInt = i;
      if (this.Luk != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Luk);
      }
      i = paramInt;
      if (this.Luj != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Luj);
      }
      paramInt = i;
      if (this.MOI != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MOI);
      }
      AppMethodBeat.o(212300);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212300);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dlb localdlb = (dlb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212300);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdlb.MOX = ((mr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212300);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdlb.MOY = ((cdu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212300);
          return 0;
        case 3: 
          localdlb.KWw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212300);
          return 0;
        case 4: 
          localdlb.Luk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212300);
          return 0;
        case 5: 
          localdlb.Luj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212300);
          return 0;
        }
        localdlb.MOI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(212300);
        return 0;
      }
      AppMethodBeat.o(212300);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlb
 * JD-Core Version:    0.7.0.1
 */