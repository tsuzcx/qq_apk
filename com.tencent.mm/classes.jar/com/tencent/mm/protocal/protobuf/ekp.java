package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ekp
  extends dop
{
  public cds NjO;
  public LinkedList<eg> NjP;
  public String link;
  public int scene;
  
  public ekp()
  {
    AppMethodBeat.i(152712);
    this.NjP = new LinkedList();
    AppMethodBeat.o(152712);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152713);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.link != null) {
        paramVarArgs.e(2, this.link);
      }
      paramVarArgs.aM(3, this.scene);
      if (this.NjO != null)
      {
        paramVarArgs.ni(4, this.NjO.computeSize());
        this.NjO.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.NjP);
      AppMethodBeat.o(152713);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.link != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.link);
      }
      i += g.a.a.b.b.a.bu(3, this.scene);
      paramInt = i;
      if (this.NjO != null) {
        paramInt = i + g.a.a.a.nh(4, this.NjO.computeSize());
      }
      i = g.a.a.a.c(5, 8, this.NjP);
      AppMethodBeat.o(152713);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NjP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152713);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ekp localekp = (ekp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152713);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localekp.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152713);
          return 0;
        case 2: 
          localekp.link = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152713);
          return 0;
        case 3: 
          localekp.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152713);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cds();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cds)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localekp.NjO = ((cds)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152713);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localekp.NjP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152713);
        return 0;
      }
      AppMethodBeat.o(152713);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekp
 * JD-Core Version:    0.7.0.1
 */