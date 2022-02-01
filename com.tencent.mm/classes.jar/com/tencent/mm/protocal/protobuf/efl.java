package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efl
  extends com.tencent.mm.bx.a
{
  public agl abkP;
  public agl abkQ;
  public agl abkR;
  public agl abkS;
  public int bottom;
  public int left;
  public int right;
  public int top;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118412);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.left);
      paramVarArgs.bS(2, this.top);
      paramVarArgs.bS(3, this.right);
      paramVarArgs.bS(4, this.bottom);
      if (this.abkP != null)
      {
        paramVarArgs.qD(5, this.abkP.computeSize());
        this.abkP.writeFields(paramVarArgs);
      }
      if (this.abkQ != null)
      {
        paramVarArgs.qD(6, this.abkQ.computeSize());
        this.abkQ.writeFields(paramVarArgs);
      }
      if (this.abkR != null)
      {
        paramVarArgs.qD(7, this.abkR.computeSize());
        this.abkR.writeFields(paramVarArgs);
      }
      if (this.abkS != null)
      {
        paramVarArgs.qD(8, this.abkS.computeSize());
        this.abkS.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(100, this.type);
      AppMethodBeat.o(118412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.left) + 0 + i.a.a.b.b.a.cJ(2, this.top) + i.a.a.b.b.a.cJ(3, this.right) + i.a.a.b.b.a.cJ(4, this.bottom);
      paramInt = i;
      if (this.abkP != null) {
        paramInt = i + i.a.a.a.qC(5, this.abkP.computeSize());
      }
      i = paramInt;
      if (this.abkQ != null) {
        i = paramInt + i.a.a.a.qC(6, this.abkQ.computeSize());
      }
      paramInt = i;
      if (this.abkR != null) {
        paramInt = i + i.a.a.a.qC(7, this.abkR.computeSize());
      }
      i = paramInt;
      if (this.abkS != null) {
        i = paramInt + i.a.a.a.qC(8, this.abkS.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(100, this.type);
      AppMethodBeat.o(118412);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(118412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      efl localefl = (efl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      agl localagl;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118412);
        return -1;
      case 1: 
        localefl.left = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118412);
        return 0;
      case 2: 
        localefl.top = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118412);
        return 0;
      case 3: 
        localefl.right = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118412);
        return 0;
      case 4: 
        localefl.bottom = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118412);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localagl = new agl();
          if ((localObject != null) && (localObject.length > 0)) {
            localagl.parseFrom((byte[])localObject);
          }
          localefl.abkP = localagl;
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localagl = new agl();
          if ((localObject != null) && (localObject.length > 0)) {
            localagl.parseFrom((byte[])localObject);
          }
          localefl.abkQ = localagl;
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localagl = new agl();
          if ((localObject != null) && (localObject.length > 0)) {
            localagl.parseFrom((byte[])localObject);
          }
          localefl.abkR = localagl;
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localagl = new agl();
          if ((localObject != null) && (localObject.length > 0)) {
            localagl.parseFrom((byte[])localObject);
          }
          localefl.abkS = localagl;
          paramInt += 1;
        }
        AppMethodBeat.o(118412);
        return 0;
      }
      localefl.type = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(118412);
      return 0;
    }
    AppMethodBeat.o(118412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efl
 * JD-Core Version:    0.7.0.1
 */