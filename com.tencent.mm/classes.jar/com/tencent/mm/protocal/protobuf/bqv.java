package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class bqv
  extends com.tencent.mm.bx.a
{
  public b JaK;
  public FinderJumpInfo ZNl;
  public String ZYL;
  public String ZYM;
  public String content;
  public String link;
  public int subType;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169020);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.content != null) {
        paramVarArgs.g(2, this.content);
      }
      paramVarArgs.bS(3, this.subType);
      if (this.link != null) {
        paramVarArgs.g(4, this.link);
      }
      if (this.ZYL != null) {
        paramVarArgs.g(5, this.ZYL);
      }
      if (this.JaK != null) {
        paramVarArgs.d(6, this.JaK);
      }
      if (this.ZYM != null) {
        paramVarArgs.g(7, this.ZYM);
      }
      if (this.ZNl != null)
      {
        paramVarArgs.qD(8, this.ZNl.computeSize());
        this.ZNl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169020);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label696;
      }
    }
    label696:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.content != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.content);
      }
      i += i.a.a.b.b.a.cJ(3, this.subType);
      paramInt = i;
      if (this.link != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.link);
      }
      i = paramInt;
      if (this.ZYL != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZYL);
      }
      paramInt = i;
      if (this.JaK != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.JaK);
      }
      i = paramInt;
      if (this.ZYM != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZYM);
      }
      paramInt = i;
      if (this.ZNl != null) {
        paramInt = i + i.a.a.a.qC(8, this.ZNl.computeSize());
      }
      AppMethodBeat.o(169020);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169020);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bqv localbqv = (bqv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169020);
          return -1;
        case 1: 
          localbqv.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169020);
          return 0;
        case 2: 
          localbqv.content = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169020);
          return 0;
        case 3: 
          localbqv.subType = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169020);
          return 0;
        case 4: 
          localbqv.link = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169020);
          return 0;
        case 5: 
          localbqv.ZYL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169020);
          return 0;
        case 6: 
          localbqv.JaK = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(169020);
          return 0;
        case 7: 
          localbqv.ZYM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169020);
          return 0;
        }
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
          localbqv.ZNl = localFinderJumpInfo;
          paramInt += 1;
        }
        AppMethodBeat.o(169020);
        return 0;
      }
      AppMethodBeat.o(169020);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqv
 * JD-Core Version:    0.7.0.1
 */