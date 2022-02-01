package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gmv
  extends com.tencent.mm.bx.a
{
  public String Md5;
  public int YQB;
  public gmn achK;
  public String acie;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153344);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.achK != null)
      {
        paramVarArgs.qD(1, this.achK.computeSize());
        this.achK.writeFields(paramVarArgs);
      }
      if (this.acie != null) {
        paramVarArgs.g(2, this.acie);
      }
      paramVarArgs.bS(3, this.YQB);
      if (this.Md5 != null) {
        paramVarArgs.g(4, this.Md5);
      }
      AppMethodBeat.o(153344);
      return 0;
    }
    if (paramInt == 1) {
      if (this.achK == null) {
        break label448;
      }
    }
    label448:
    for (paramInt = i.a.a.a.qC(1, this.achK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.acie != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.acie);
      }
      i += i.a.a.b.b.a.cJ(3, this.YQB);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Md5);
      }
      AppMethodBeat.o(153344);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153344);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gmv localgmv = (gmv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153344);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gmn localgmn = new gmn();
            if ((localObject != null) && (localObject.length > 0)) {
              localgmn.parseFrom((byte[])localObject);
            }
            localgmv.achK = localgmn;
            paramInt += 1;
          }
          AppMethodBeat.o(153344);
          return 0;
        case 2: 
          localgmv.acie = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153344);
          return 0;
        case 3: 
          localgmv.YQB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(153344);
          return 0;
        }
        localgmv.Md5 = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(153344);
        return 0;
      }
      AppMethodBeat.o(153344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gmv
 * JD-Core Version:    0.7.0.1
 */