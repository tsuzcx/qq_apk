package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class beq
  extends dop
{
  public String APy;
  public String Bri;
  public String KPP;
  public String LOs;
  public String LOt;
  public String LOu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91466);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LOs != null) {
        paramVarArgs.e(2, this.LOs);
      }
      if (this.KPP != null) {
        paramVarArgs.e(3, this.KPP);
      }
      if (this.APy != null) {
        paramVarArgs.e(4, this.APy);
      }
      if (this.LOt != null) {
        paramVarArgs.e(5, this.LOt);
      }
      if (this.LOu != null) {
        paramVarArgs.e(6, this.LOu);
      }
      if (this.Bri != null) {
        paramVarArgs.e(7, this.Bri);
      }
      AppMethodBeat.o(91466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LOs != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LOs);
      }
      i = paramInt;
      if (this.KPP != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KPP);
      }
      paramInt = i;
      if (this.APy != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.APy);
      }
      i = paramInt;
      if (this.LOt != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LOt);
      }
      paramInt = i;
      if (this.LOu != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LOu);
      }
      i = paramInt;
      if (this.Bri != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Bri);
      }
      AppMethodBeat.o(91466);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91466);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        beq localbeq = (beq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91466);
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
            localbeq.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91466);
          return 0;
        case 2: 
          localbeq.LOs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 3: 
          localbeq.KPP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 4: 
          localbeq.APy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 5: 
          localbeq.LOt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 6: 
          localbeq.LOu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91466);
          return 0;
        }
        localbeq.Bri = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91466);
        return 0;
      }
      AppMethodBeat.o(91466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beq
 * JD-Core Version:    0.7.0.1
 */