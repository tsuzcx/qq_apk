package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcl
  extends com.tencent.mm.bx.a
{
  public efg aaIp;
  public efg aaIq;
  public int aaIr;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259185);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      if (this.aaIp != null)
      {
        paramVarArgs.qD(2, this.aaIp.computeSize());
        this.aaIp.writeFields(paramVarArgs);
      }
      if (this.aaIq != null)
      {
        paramVarArgs.qD(3, this.aaIq.computeSize());
        this.aaIq.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.aaIr);
      AppMethodBeat.o(259185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label522;
      }
    }
    label522:
    for (int i = i.a.a.b.b.a.h(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaIp != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaIp.computeSize());
      }
      i = paramInt;
      if (this.aaIq != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaIq.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.aaIr);
      AppMethodBeat.o(259185);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259185);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dcl localdcl = (dcl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        efg localefg;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259185);
          return -1;
        case 1: 
          localdcl.wording = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259185);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localefg = new efg();
            if ((localObject != null) && (localObject.length > 0)) {
              localefg.parseFrom((byte[])localObject);
            }
            localdcl.aaIp = localefg;
            paramInt += 1;
          }
          AppMethodBeat.o(259185);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localefg = new efg();
            if ((localObject != null) && (localObject.length > 0)) {
              localefg.parseFrom((byte[])localObject);
            }
            localdcl.aaIq = localefg;
            paramInt += 1;
          }
          AppMethodBeat.o(259185);
          return 0;
        }
        localdcl.aaIr = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259185);
        return 0;
      }
      AppMethodBeat.o(259185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcl
 * JD-Core Version:    0.7.0.1
 */