package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dua
  extends dop
{
  public String AAN;
  public String KHk;
  public String MVL;
  public String MVM;
  public String Name;
  public String xJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155459);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xJz != null) {
        paramVarArgs.e(2, this.xJz);
      }
      if (this.MVL != null) {
        paramVarArgs.e(3, this.MVL);
      }
      if (this.AAN != null) {
        paramVarArgs.e(5, this.AAN);
      }
      if (this.Name != null) {
        paramVarArgs.e(4, this.Name);
      }
      if (this.KHk != null) {
        paramVarArgs.e(6, this.KHk);
      }
      if (this.MVM != null) {
        paramVarArgs.e(7, this.MVM);
      }
      AppMethodBeat.o(155459);
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
      if (this.xJz != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xJz);
      }
      i = paramInt;
      if (this.MVL != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MVL);
      }
      paramInt = i;
      if (this.AAN != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.AAN);
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Name);
      }
      paramInt = i;
      if (this.KHk != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KHk);
      }
      i = paramInt;
      if (this.MVM != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MVM);
      }
      AppMethodBeat.o(155459);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(155459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dua localdua = (dua)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155459);
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
            localdua.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155459);
          return 0;
        case 2: 
          localdua.xJz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 3: 
          localdua.MVL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 5: 
          localdua.AAN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 4: 
          localdua.Name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 6: 
          localdua.KHk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155459);
          return 0;
        }
        localdua.MVM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155459);
        return 0;
      }
      AppMethodBeat.o(155459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dua
 * JD-Core Version:    0.7.0.1
 */