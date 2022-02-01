package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class baj
  extends dop
{
  public FinderObjectDesc LJZ;
  public int LKa;
  public String LKb;
  public int scene;
  public aov uli;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209633);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(2, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.e(3, this.username);
      }
      if (this.LJZ != null)
      {
        paramVarArgs.ni(4, this.LJZ.computeSize());
        this.LJZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.LKa);
      if (this.LKb != null) {
        paramVarArgs.e(6, this.LKb);
      }
      paramVarArgs.aM(7, this.scene);
      AppMethodBeat.o(209633);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label830;
      }
    }
    label830:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uli != null) {
        paramInt = i + g.a.a.a.nh(2, this.uli.computeSize());
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.username);
      }
      paramInt = i;
      if (this.LJZ != null) {
        paramInt = i + g.a.a.a.nh(4, this.LJZ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.LKa);
      paramInt = i;
      if (this.LKb != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LKb);
      }
      i = g.a.a.b.b.a.bu(7, this.scene);
      AppMethodBeat.o(209633);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209633);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        baj localbaj = (baj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209633);
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
            localbaj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209633);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbaj.uli = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209633);
          return 0;
        case 3: 
          localbaj.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209633);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObjectDesc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObjectDesc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbaj.LJZ = ((FinderObjectDesc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209633);
          return 0;
        case 5: 
          localbaj.LKa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209633);
          return 0;
        case 6: 
          localbaj.LKb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209633);
          return 0;
        }
        localbaj.scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209633);
        return 0;
      }
      AppMethodBeat.o(209633);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baj
 * JD-Core Version:    0.7.0.1
 */