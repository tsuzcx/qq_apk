package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bx
  extends erp
{
  public String adExtInfo;
  public int enterScene;
  public String rzx;
  public String uxInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259413);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.rzx != null) {
        paramVarArgs.g(2, this.rzx);
      }
      if (this.uxInfo != null) {
        paramVarArgs.g(3, this.uxInfo);
      }
      paramVarArgs.bS(4, this.enterScene);
      if (this.adExtInfo != null) {
        paramVarArgs.g(5, this.adExtInfo);
      }
      AppMethodBeat.o(259413);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label508;
      }
    }
    label508:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rzx != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.rzx);
      }
      i = paramInt;
      if (this.uxInfo != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.uxInfo);
      }
      i += i.a.a.b.b.a.cJ(4, this.enterScene);
      paramInt = i;
      if (this.adExtInfo != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.adExtInfo);
      }
      AppMethodBeat.o(259413);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259413);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bx localbx = (bx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259413);
          return -1;
        case 1: 
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
            localbx.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259413);
          return 0;
        case 2: 
          localbx.rzx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259413);
          return 0;
        case 3: 
          localbx.uxInfo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259413);
          return 0;
        case 4: 
          localbx.enterScene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259413);
          return 0;
        }
        localbx.adExtInfo = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259413);
        return 0;
      }
      AppMethodBeat.o(259413);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bx
 * JD-Core Version:    0.7.0.1
 */