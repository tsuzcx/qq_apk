package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btk
  extends dop
{
  public String DYM;
  public String Mab;
  public String Mac;
  public String Mad;
  public String dRy;
  public String gTk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192777);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dRy != null) {
        paramVarArgs.e(2, this.dRy);
      }
      if (this.DYM != null) {
        paramVarArgs.e(3, this.DYM);
      }
      if (this.Mab != null) {
        paramVarArgs.e(4, this.Mab);
      }
      if (this.gTk != null) {
        paramVarArgs.e(5, this.gTk);
      }
      if (this.Mac != null) {
        paramVarArgs.e(6, this.Mac);
      }
      if (this.Mad != null) {
        paramVarArgs.e(7, this.Mad);
      }
      AppMethodBeat.o(192777);
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
      if (this.dRy != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dRy);
      }
      i = paramInt;
      if (this.DYM != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.DYM);
      }
      paramInt = i;
      if (this.Mab != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mab);
      }
      i = paramInt;
      if (this.gTk != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.gTk);
      }
      paramInt = i;
      if (this.Mac != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Mac);
      }
      i = paramInt;
      if (this.Mad != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Mad);
      }
      AppMethodBeat.o(192777);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(192777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        btk localbtk = (btk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(192777);
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
            localbtk.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192777);
          return 0;
        case 2: 
          localbtk.dRy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(192777);
          return 0;
        case 3: 
          localbtk.DYM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(192777);
          return 0;
        case 4: 
          localbtk.Mab = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(192777);
          return 0;
        case 5: 
          localbtk.gTk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(192777);
          return 0;
        case 6: 
          localbtk.Mac = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(192777);
          return 0;
        }
        localbtk.Mad = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(192777);
        return 0;
      }
      AppMethodBeat.o(192777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btk
 * JD-Core Version:    0.7.0.1
 */