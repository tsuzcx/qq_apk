package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnk
  extends dop
{
  public String MBV;
  public String MQD;
  public int dYn;
  public String yQE;
  public String yVy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116341);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.yQE != null) {
        paramVarArgs.e(2, this.yQE);
      }
      if (this.MBV != null) {
        paramVarArgs.e(3, this.MBV);
      }
      paramVarArgs.aM(4, this.dYn);
      if (this.yVy != null) {
        paramVarArgs.e(5, this.yVy);
      }
      if (this.MQD != null) {
        paramVarArgs.e(6, this.MQD);
      }
      AppMethodBeat.o(116341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.yQE != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.yQE);
      }
      i = paramInt;
      if (this.MBV != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MBV);
      }
      i += g.a.a.b.b.a.bu(4, this.dYn);
      paramInt = i;
      if (this.yVy != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.yVy);
      }
      i = paramInt;
      if (this.MQD != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MQD);
      }
      AppMethodBeat.o(116341);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(116341);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dnk localdnk = (dnk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116341);
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
            localdnk.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116341);
          return 0;
        case 2: 
          localdnk.yQE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116341);
          return 0;
        case 3: 
          localdnk.MBV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116341);
          return 0;
        case 4: 
          localdnk.dYn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116341);
          return 0;
        case 5: 
          localdnk.yVy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116341);
          return 0;
        }
        localdnk.MQD = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(116341);
        return 0;
      }
      AppMethodBeat.o(116341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnk
 * JD-Core Version:    0.7.0.1
 */