package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class buj
  extends dyy
{
  public int Teg;
  public LinkedList<akc> Teh;
  public LinkedList<akf> VIg;
  public akg VIh;
  
  public buj()
  {
    AppMethodBeat.i(104803);
    this.VIg = new LinkedList();
    this.Teh = new LinkedList();
    AppMethodBeat.o(104803);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104804);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104804);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.VIg);
      paramVarArgs.aY(3, this.Teg);
      paramVarArgs.e(4, 8, this.Teh);
      if (this.VIh != null)
      {
        paramVarArgs.oE(5, this.VIh.computeSize());
        this.VIh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.VIg) + g.a.a.b.b.a.bM(3, this.Teg) + g.a.a.a.c(4, 8, this.Teh);
      paramInt = i;
      if (this.VIh != null) {
        paramInt = i + g.a.a.a.oD(5, this.VIh.computeSize());
      }
      AppMethodBeat.o(104804);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.VIg.clear();
        this.Teh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104804);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104804);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        buj localbuj = (buj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104804);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbuj.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104804);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new akf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((akf)localObject2).parseFrom((byte[])localObject1);
            }
            localbuj.VIg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104804);
          return 0;
        case 3: 
          localbuj.Teg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(104804);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new akc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((akc)localObject2).parseFrom((byte[])localObject1);
            }
            localbuj.Teh.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104804);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new akg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((akg)localObject2).parseFrom((byte[])localObject1);
          }
          localbuj.VIh = ((akg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104804);
        return 0;
      }
      AppMethodBeat.o(104804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buj
 * JD-Core Version:    0.7.0.1
 */