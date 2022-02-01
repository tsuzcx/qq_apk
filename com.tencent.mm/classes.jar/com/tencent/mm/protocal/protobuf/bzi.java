package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bzi
  extends com.tencent.mm.bx.a
{
  public int aaiz;
  public int createTime;
  public dmz ibT;
  public String parentId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257613);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ibT != null)
      {
        paramVarArgs.qD(1, this.ibT.computeSize());
        this.ibT.writeFields(paramVarArgs);
      }
      if (this.parentId != null) {
        paramVarArgs.g(2, this.parentId);
      }
      paramVarArgs.bS(3, this.createTime);
      paramVarArgs.bS(4, this.aaiz);
      AppMethodBeat.o(257613);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ibT == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = i.a.a.a.qC(1, this.ibT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.parentId != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.parentId);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.createTime);
      int j = i.a.a.b.b.a.cJ(4, this.aaiz);
      AppMethodBeat.o(257613);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257613);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bzi localbzi = (bzi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257613);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dmz localdmz = new dmz();
            if ((localObject != null) && (localObject.length > 0)) {
              localdmz.parseFrom((byte[])localObject);
            }
            localbzi.ibT = localdmz;
            paramInt += 1;
          }
          AppMethodBeat.o(257613);
          return 0;
        case 2: 
          localbzi.parentId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257613);
          return 0;
        case 3: 
          localbzi.createTime = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257613);
          return 0;
        }
        localbzi.aaiz = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257613);
        return 0;
      }
      AppMethodBeat.o(257613);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzi
 * JD-Core Version:    0.7.0.1
 */