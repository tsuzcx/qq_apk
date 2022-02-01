package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eyt
  extends com.tencent.mm.cd.a
{
  public LinkedList<eqk> UyW;
  public LinkedList<eqk> UyX;
  public LinkedList<acg> UyY;
  public String title;
  
  public eyt()
  {
    AppMethodBeat.i(114083);
    this.UyW = new LinkedList();
    this.UyX = new LinkedList();
    this.UyY = new LinkedList();
    AppMethodBeat.o(114083);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114084);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      paramVarArgs.e(2, 8, this.UyW);
      paramVarArgs.e(3, 8, this.UyX);
      paramVarArgs.e(4, 8, this.UyY);
      AppMethodBeat.o(114084);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = g.a.a.b.b.a.g(1, this.title) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.UyW);
      int j = g.a.a.a.c(3, 8, this.UyX);
      int k = g.a.a.a.c(4, 8, this.UyY);
      AppMethodBeat.o(114084);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UyW.clear();
        this.UyX.clear();
        this.UyY.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114084);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eyt localeyt = (eyt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114084);
          return -1;
        case 1: 
          localeyt.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114084);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eqk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eqk)localObject2).parseFrom((byte[])localObject1);
            }
            localeyt.UyW.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114084);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eqk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eqk)localObject2).parseFrom((byte[])localObject1);
            }
            localeyt.UyX.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114084);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new acg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((acg)localObject2).parseFrom((byte[])localObject1);
          }
          localeyt.UyY.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(114084);
        return 0;
      }
      AppMethodBeat.o(114084);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyt
 * JD-Core Version:    0.7.0.1
 */