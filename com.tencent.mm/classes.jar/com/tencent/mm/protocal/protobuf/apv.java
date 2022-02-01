package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apv
  extends com.tencent.mm.bx.a
{
  public LinkedList<apu> Oiy;
  public String Zxi;
  public String title;
  
  public apv()
  {
    AppMethodBeat.i(259363);
    this.Oiy = new LinkedList();
    AppMethodBeat.o(259363);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259365);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zxi != null) {
        paramVarArgs.g(1, this.Zxi);
      }
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      paramVarArgs.e(3, 8, this.Oiy);
      AppMethodBeat.o(259365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zxi == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = i.a.a.b.b.a.h(1, this.Zxi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.title);
      }
      paramInt = i.a.a.a.c(3, 8, this.Oiy);
      AppMethodBeat.o(259365);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Oiy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        apv localapv = (apv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259365);
          return -1;
        case 1: 
          localapv.Zxi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259365);
          return 0;
        case 2: 
          localapv.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259365);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          apu localapu = new apu();
          if ((localObject != null) && (localObject.length > 0)) {
            localapu.parseFrom((byte[])localObject);
          }
          localapv.Oiy.add(localapu);
          paramInt += 1;
        }
        AppMethodBeat.o(259365);
        return 0;
      }
      AppMethodBeat.o(259365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apv
 * JD-Core Version:    0.7.0.1
 */