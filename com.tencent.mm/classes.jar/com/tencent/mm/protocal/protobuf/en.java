package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class en
  extends com.tencent.mm.bx.a
{
  public LinkedList<cxu> GroupList;
  public String IJD;
  public hl YGD;
  
  public en()
  {
    AppMethodBeat.i(125706);
    this.GroupList = new LinkedList();
    AppMethodBeat.o(125706);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125707);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGD == null)
      {
        paramVarArgs = new b("Not all required fields were included: ArtisAuthor");
        AppMethodBeat.o(125707);
        throw paramVarArgs;
      }
      if (this.YGD != null)
      {
        paramVarArgs.qD(1, this.YGD.computeSize());
        this.YGD.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GroupList);
      if (this.IJD != null) {
        paramVarArgs.g(3, this.IJD);
      }
      AppMethodBeat.o(125707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGD == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = i.a.a.a.qC(1, this.YGD.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.GroupList);
      paramInt = i;
      if (this.IJD != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IJD);
      }
      AppMethodBeat.o(125707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GroupList.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YGD == null)
        {
          paramVarArgs = new b("Not all required fields were included: ArtisAuthor");
          AppMethodBeat.o(125707);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125707);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        en localen = (en)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125707);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new hl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((hl)localObject2).parseFrom((byte[])localObject1);
            }
            localen.YGD = ((hl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125707);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cxu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cxu)localObject2).parseFrom((byte[])localObject1);
            }
            localen.GroupList.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125707);
          return 0;
        }
        localen.IJD = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(125707);
        return 0;
      }
      AppMethodBeat.o(125707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.en
 * JD-Core Version:    0.7.0.1
 */