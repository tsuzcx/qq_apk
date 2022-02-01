package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class etj
  extends com.tencent.mm.bx.a
{
  public boolean BrJ;
  public String abwI;
  public String appid;
  public String businessType;
  public String eventName;
  public String extInfo;
  public FinderJumpInfo hVf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258049);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.businessType != null) {
        paramVarArgs.g(1, this.businessType);
      }
      if (this.appid != null) {
        paramVarArgs.g(2, this.appid);
      }
      if (this.extInfo != null) {
        paramVarArgs.g(3, this.extInfo);
      }
      paramVarArgs.di(4, this.BrJ);
      if (this.hVf != null)
      {
        paramVarArgs.qD(5, this.hVf.computeSize());
        this.hVf.writeFields(paramVarArgs);
      }
      if (this.eventName != null) {
        paramVarArgs.g(6, this.eventName);
      }
      if (this.abwI != null) {
        paramVarArgs.g(7, this.abwI);
      }
      AppMethodBeat.o(258049);
      return 0;
    }
    if (paramInt == 1) {
      if (this.businessType == null) {
        break label632;
      }
    }
    label632:
    for (int i = i.a.a.b.b.a.h(1, this.businessType) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appid);
      }
      i = paramInt;
      if (this.extInfo != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.extInfo);
      }
      i += i.a.a.b.b.a.ko(4) + 1;
      paramInt = i;
      if (this.hVf != null) {
        paramInt = i + i.a.a.a.qC(5, this.hVf.computeSize());
      }
      i = paramInt;
      if (this.eventName != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.eventName);
      }
      paramInt = i;
      if (this.abwI != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abwI);
      }
      AppMethodBeat.o(258049);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258049);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        etj localetj = (etj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258049);
          return -1;
        case 1: 
          localetj.businessType = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258049);
          return 0;
        case 2: 
          localetj.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258049);
          return 0;
        case 3: 
          localetj.extInfo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258049);
          return 0;
        case 4: 
          localetj.BrJ = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(258049);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            FinderJumpInfo localFinderJumpInfo = new FinderJumpInfo();
            if ((localObject != null) && (localObject.length > 0)) {
              localFinderJumpInfo.parseFrom((byte[])localObject);
            }
            localetj.hVf = localFinderJumpInfo;
            paramInt += 1;
          }
          AppMethodBeat.o(258049);
          return 0;
        case 6: 
          localetj.eventName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258049);
          return 0;
        }
        localetj.abwI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258049);
        return 0;
      }
      AppMethodBeat.o(258049);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etj
 * JD-Core Version:    0.7.0.1
 */