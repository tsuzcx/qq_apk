package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pl
  extends esc
{
  public boolean YST;
  public int hNv;
  public String hNw;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258307);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.YST);
      paramVarArgs.bS(3, this.hNv);
      if (this.hNw != null) {
        paramVarArgs.g(4, this.hNw);
      }
      if (this.url != null) {
        paramVarArgs.g(5, this.url);
      }
      AppMethodBeat.o(258307);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label488;
      }
    }
    label488:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1) + i.a.a.b.b.a.cJ(3, this.hNv);
      paramInt = i;
      if (this.hNw != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.hNw);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.url);
      }
      AppMethodBeat.o(258307);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258307);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        pl localpl = (pl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258307);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localpl.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258307);
          return 0;
        case 2: 
          localpl.YST = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(258307);
          return 0;
        case 3: 
          localpl.hNv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258307);
          return 0;
        case 4: 
          localpl.hNw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258307);
          return 0;
        }
        localpl.url = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258307);
        return 0;
      }
      AppMethodBeat.o(258307);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pl
 * JD-Core Version:    0.7.0.1
 */