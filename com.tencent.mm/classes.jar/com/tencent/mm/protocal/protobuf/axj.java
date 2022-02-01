package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axj
  extends erp
{
  public String ZIw;
  public String ZIx;
  public String clientId;
  public String url;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259748);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.clientId != null) {
        paramVarArgs.g(2, this.clientId);
      }
      if (this.url != null) {
        paramVarArgs.g(3, this.url);
      }
      if (this.ZIw != null) {
        paramVarArgs.g(4, this.ZIw);
      }
      if (this.ZIx != null) {
        paramVarArgs.g(5, this.ZIx);
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(6, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259748);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label588;
      }
    }
    label588:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.clientId);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.url);
      }
      paramInt = i;
      if (this.ZIw != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZIw);
      }
      i = paramInt;
      if (this.ZIx != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZIx);
      }
      paramInt = i;
      if (this.BaseRequest != null) {
        paramInt = i + i.a.a.a.qC(6, this.BaseRequest.computeSize());
      }
      AppMethodBeat.o(259748);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259748);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        axj localaxj = (axj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259748);
          return -1;
        case 1: 
          localaxj.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259748);
          return 0;
        case 2: 
          localaxj.clientId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259748);
          return 0;
        case 3: 
          localaxj.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259748);
          return 0;
        case 4: 
          localaxj.ZIw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259748);
          return 0;
        case 5: 
          localaxj.ZIx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259748);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          kc localkc = new kc();
          if ((localObject != null) && (localObject.length > 0)) {
            localkc.parseFrom((byte[])localObject);
          }
          localaxj.BaseRequest = localkc;
          paramInt += 1;
        }
        AppMethodBeat.o(259748);
        return 0;
      }
      AppMethodBeat.o(259748);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axj
 * JD-Core Version:    0.7.0.1
 */