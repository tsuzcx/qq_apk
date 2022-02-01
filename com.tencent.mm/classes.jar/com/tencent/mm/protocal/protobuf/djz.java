package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djz
  extends dop
{
  public String Cyk;
  public int MlF;
  public String hid;
  public String hie;
  public String hif;
  public String hig;
  public String hih;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152666);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hid != null) {
        paramVarArgs.e(2, this.hid);
      }
      if (this.hie != null) {
        paramVarArgs.e(3, this.hie);
      }
      if (this.hif != null) {
        paramVarArgs.e(4, this.hif);
      }
      if (this.hig != null) {
        paramVarArgs.e(5, this.hig);
      }
      if (this.hih != null) {
        paramVarArgs.e(6, this.hih);
      }
      paramVarArgs.aM(7, this.MlF);
      if (this.Cyk != null) {
        paramVarArgs.e(8, this.Cyk);
      }
      AppMethodBeat.o(152666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hid != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.hid);
      }
      i = paramInt;
      if (this.hie != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.hie);
      }
      paramInt = i;
      if (this.hif != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.hif);
      }
      i = paramInt;
      if (this.hig != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.hig);
      }
      paramInt = i;
      if (this.hih != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.hih);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.MlF);
      paramInt = i;
      if (this.Cyk != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Cyk);
      }
      AppMethodBeat.o(152666);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        djz localdjz = (djz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152666);
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
            localdjz.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152666);
          return 0;
        case 2: 
          localdjz.hid = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 3: 
          localdjz.hie = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 4: 
          localdjz.hif = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 5: 
          localdjz.hig = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 6: 
          localdjz.hih = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 7: 
          localdjz.MlF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152666);
          return 0;
        }
        localdjz.Cyk = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152666);
        return 0;
      }
      AppMethodBeat.o(152666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djz
 * JD-Core Version:    0.7.0.1
 */