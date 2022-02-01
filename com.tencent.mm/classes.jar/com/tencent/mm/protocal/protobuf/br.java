package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class br
  extends com.tencent.mm.bw.a
{
  public String KFq;
  public String KFr;
  public String KFs;
  public String KFt;
  public String KFu;
  public String KFv;
  public ffi KFw;
  public String KFx;
  public String hik;
  public String xJM;
  public String xMq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152478);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.hik != null) {
        paramVarArgs.e(1, this.hik);
      }
      if (this.KFq != null) {
        paramVarArgs.e(2, this.KFq);
      }
      if (this.KFr != null) {
        paramVarArgs.e(3, this.KFr);
      }
      if (this.xJM != null) {
        paramVarArgs.e(4, this.xJM);
      }
      if (this.xMq != null) {
        paramVarArgs.e(5, this.xMq);
      }
      if (this.KFs != null) {
        paramVarArgs.e(6, this.KFs);
      }
      if (this.KFt != null) {
        paramVarArgs.e(7, this.KFt);
      }
      if (this.KFu != null) {
        paramVarArgs.e(8, this.KFu);
      }
      if (this.KFv != null) {
        paramVarArgs.e(9, this.KFv);
      }
      if (this.KFw != null)
      {
        paramVarArgs.ni(10, this.KFw.computeSize());
        this.KFw.writeFields(paramVarArgs);
      }
      if (this.KFx != null) {
        paramVarArgs.e(11, this.KFx);
      }
      AppMethodBeat.o(152478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hik == null) {
        break label922;
      }
    }
    label922:
    for (int i = g.a.a.b.b.a.f(1, this.hik) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KFq != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KFq);
      }
      i = paramInt;
      if (this.KFr != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KFr);
      }
      paramInt = i;
      if (this.xJM != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xJM);
      }
      i = paramInt;
      if (this.xMq != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xMq);
      }
      paramInt = i;
      if (this.KFs != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KFs);
      }
      i = paramInt;
      if (this.KFt != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KFt);
      }
      paramInt = i;
      if (this.KFu != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KFu);
      }
      i = paramInt;
      if (this.KFv != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.KFv);
      }
      paramInt = i;
      if (this.KFw != null) {
        paramInt = i + g.a.a.a.nh(10, this.KFw.computeSize());
      }
      i = paramInt;
      if (this.KFx != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.KFx);
      }
      AppMethodBeat.o(152478);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        br localbr = (br)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152478);
          return -1;
        case 1: 
          localbr.hik = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 2: 
          localbr.KFq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 3: 
          localbr.KFr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 4: 
          localbr.xJM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 5: 
          localbr.xMq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 6: 
          localbr.KFs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 7: 
          localbr.KFt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 8: 
          localbr.KFu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 9: 
          localbr.KFv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ffi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ffi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbr.KFw = ((ffi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152478);
          return 0;
        }
        localbr.KFx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152478);
        return 0;
      }
      AppMethodBeat.o(152478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.br
 * JD-Core Version:    0.7.0.1
 */