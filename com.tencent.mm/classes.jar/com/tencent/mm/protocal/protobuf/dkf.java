package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkf
  extends com.tencent.mm.bx.a
{
  public dkg aaQk;
  public dkg aaQl;
  public dkg aaQm;
  public int style;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259581);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      paramVarArgs.bS(2, this.style);
      if (this.aaQk != null)
      {
        paramVarArgs.qD(3, this.aaQk.computeSize());
        this.aaQk.writeFields(paramVarArgs);
      }
      if (this.aaQl != null)
      {
        paramVarArgs.qD(4, this.aaQl.computeSize());
        this.aaQl.writeFields(paramVarArgs);
      }
      if (this.aaQm != null)
      {
        paramVarArgs.qD(5, this.aaQm.computeSize());
        this.aaQm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259581);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label652;
      }
    }
    label652:
    for (paramInt = i.a.a.b.b.a.h(1, this.wording) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.style);
      paramInt = i;
      if (this.aaQk != null) {
        paramInt = i + i.a.a.a.qC(3, this.aaQk.computeSize());
      }
      i = paramInt;
      if (this.aaQl != null) {
        i = paramInt + i.a.a.a.qC(4, this.aaQl.computeSize());
      }
      paramInt = i;
      if (this.aaQm != null) {
        paramInt = i + i.a.a.a.qC(5, this.aaQm.computeSize());
      }
      AppMethodBeat.o(259581);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259581);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dkf localdkf = (dkf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        dkg localdkg;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259581);
          return -1;
        case 1: 
          localdkf.wording = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259581);
          return 0;
        case 2: 
          localdkf.style = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259581);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdkg = new dkg();
            if ((localObject != null) && (localObject.length > 0)) {
              localdkg.parseFrom((byte[])localObject);
            }
            localdkf.aaQk = localdkg;
            paramInt += 1;
          }
          AppMethodBeat.o(259581);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdkg = new dkg();
            if ((localObject != null) && (localObject.length > 0)) {
              localdkg.parseFrom((byte[])localObject);
            }
            localdkf.aaQl = localdkg;
            paramInt += 1;
          }
          AppMethodBeat.o(259581);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdkg = new dkg();
          if ((localObject != null) && (localObject.length > 0)) {
            localdkg.parseFrom((byte[])localObject);
          }
          localdkf.aaQm = localdkg;
          paramInt += 1;
        }
        AppMethodBeat.o(259581);
        return 0;
      }
      AppMethodBeat.o(259581);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkf
 * JD-Core Version:    0.7.0.1
 */