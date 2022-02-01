package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cem
  extends esc
{
  public LinkedList<String> aaoy;
  public String aaoz;
  public String title;
  public String xlO;
  
  public cem()
  {
    AppMethodBeat.i(181502);
    this.aaoy = new LinkedList();
    AppMethodBeat.o(181502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181503);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xlO != null) {
        paramVarArgs.g(2, this.xlO);
      }
      paramVarArgs.e(3, 1, this.aaoy);
      if (this.aaoz != null) {
        paramVarArgs.g(4, this.aaoz);
      }
      if (this.title != null) {
        paramVarArgs.g(5, this.title);
      }
      AppMethodBeat.o(181503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label524;
      }
    }
    label524:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xlO != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.xlO);
      }
      i += i.a.a.a.c(3, 1, this.aaoy);
      paramInt = i;
      if (this.aaoz != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaoz);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.title);
      }
      AppMethodBeat.o(181503);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaoy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(181503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cem localcem = (cem)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(181503);
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
            localcem.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(181503);
          return 0;
        case 2: 
          localcem.xlO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(181503);
          return 0;
        case 3: 
          localcem.aaoy.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(181503);
          return 0;
        case 4: 
          localcem.aaoz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(181503);
          return 0;
        }
        localcem.title = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(181503);
        return 0;
      }
      AppMethodBeat.o(181503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cem
 * JD-Core Version:    0.7.0.1
 */