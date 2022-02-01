package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ih
  extends com.tencent.mm.bx.a
{
  public LinkedList<ig> YJT;
  public String desc;
  public String title;
  
  public ih()
  {
    AppMethodBeat.i(123550);
    this.YJT = new LinkedList();
    AppMethodBeat.o(123550);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123551);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      paramVarArgs.e(3, 8, this.YJT);
      AppMethodBeat.o(123551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.desc);
      }
      paramInt = i.a.a.a.c(3, 8, this.YJT);
      AppMethodBeat.o(123551);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YJT.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ih localih = (ih)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123551);
          return -1;
        case 1: 
          localih.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123551);
          return 0;
        case 2: 
          localih.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(123551);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ig localig = new ig();
          if ((localObject != null) && (localObject.length > 0)) {
            localig.parseFrom((byte[])localObject);
          }
          localih.YJT.add(localig);
          paramInt += 1;
        }
        AppMethodBeat.o(123551);
        return 0;
      }
      AppMethodBeat.o(123551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ih
 * JD-Core Version:    0.7.0.1
 */