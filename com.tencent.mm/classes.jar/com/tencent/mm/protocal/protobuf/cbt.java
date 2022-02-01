package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class cbt
  extends dyy
{
  public com.tencent.mm.cd.b Tkb;
  public LinkedList<dug> Tkd;
  public duj Tke;
  public String Tkf;
  
  public cbt()
  {
    AppMethodBeat.i(206477);
    this.Tkd = new LinkedList();
    AppMethodBeat.o(206477);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206480);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(206480);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Tkd);
      if (this.Tke != null)
      {
        paramVarArgs.oE(3, this.Tke.computeSize());
        this.Tke.writeFields(paramVarArgs);
      }
      if (this.Tkf != null) {
        paramVarArgs.f(4, this.Tkf);
      }
      if (this.Tkb != null) {
        paramVarArgs.c(5, this.Tkb);
      }
      AppMethodBeat.o(206480);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label708;
      }
    }
    label708:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Tkd);
      paramInt = i;
      if (this.Tke != null) {
        paramInt = i + g.a.a.a.oD(3, this.Tke.computeSize());
      }
      i = paramInt;
      if (this.Tkf != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Tkf);
      }
      paramInt = i;
      if (this.Tkb != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.Tkb);
      }
      AppMethodBeat.o(206480);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tkd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(206480);
          throw paramVarArgs;
        }
        AppMethodBeat.o(206480);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cbt localcbt = (cbt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206480);
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
            localcbt.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206480);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dug();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dug)localObject2).parseFrom((byte[])localObject1);
            }
            localcbt.Tkd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206480);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duj)localObject2).parseFrom((byte[])localObject1);
            }
            localcbt.Tke = ((duj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206480);
          return 0;
        case 4: 
          localcbt.Tkf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206480);
          return 0;
        }
        localcbt.Tkb = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(206480);
        return 0;
      }
      AppMethodBeat.o(206480);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbt
 * JD-Core Version:    0.7.0.1
 */