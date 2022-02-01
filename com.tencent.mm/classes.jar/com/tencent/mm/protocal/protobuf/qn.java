package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qn
  extends dop
{
  public int KCx;
  public String KCy;
  public String KSV;
  public cjz KXs;
  public dqu KXt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32149);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KSV != null) {
        paramVarArgs.e(2, this.KSV);
      }
      if (this.KXs != null)
      {
        paramVarArgs.ni(3, this.KXs.computeSize());
        this.KXs.writeFields(paramVarArgs);
      }
      if (this.KXt != null)
      {
        paramVarArgs.ni(4, this.KXt.computeSize());
        this.KXt.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.KCx);
      if (this.KCy != null) {
        paramVarArgs.e(6, this.KCy);
      }
      AppMethodBeat.o(32149);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KSV != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KSV);
      }
      i = paramInt;
      if (this.KXs != null) {
        i = paramInt + g.a.a.a.nh(3, this.KXs.computeSize());
      }
      paramInt = i;
      if (this.KXt != null) {
        paramInt = i + g.a.a.a.nh(4, this.KXt.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KCx);
      paramInt = i;
      if (this.KCy != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KCy);
      }
      AppMethodBeat.o(32149);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32149);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        qn localqn = (qn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32149);
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
            localqn.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32149);
          return 0;
        case 2: 
          localqn.KSV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32149);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localqn.KXs = ((cjz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32149);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localqn.KXt = ((dqu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32149);
          return 0;
        case 5: 
          localqn.KCx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32149);
          return 0;
        }
        localqn.KCy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32149);
        return 0;
      }
      AppMethodBeat.o(32149);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qn
 * JD-Core Version:    0.7.0.1
 */