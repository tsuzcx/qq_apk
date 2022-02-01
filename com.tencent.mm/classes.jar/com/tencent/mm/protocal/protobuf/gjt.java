package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gjt
  extends erp
{
  public LinkedList<gjs> acfK;
  public String acfL;
  public String acfM;
  public int acfN;
  public String acfO;
  public String acfP;
  public String acfQ;
  public String mut;
  public String muu;
  public String muw;
  
  public gjt()
  {
    AppMethodBeat.i(258073);
    this.acfK = new LinkedList();
    AppMethodBeat.o(258073);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258080);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.acfK);
      if (this.mut != null) {
        paramVarArgs.g(3, this.mut);
      }
      if (this.muu != null) {
        paramVarArgs.g(4, this.muu);
      }
      if (this.acfL != null) {
        paramVarArgs.g(5, this.acfL);
      }
      if (this.muw != null) {
        paramVarArgs.g(6, this.muw);
      }
      if (this.acfM != null) {
        paramVarArgs.g(7, this.acfM);
      }
      paramVarArgs.bS(8, this.acfN);
      if (this.acfO != null) {
        paramVarArgs.g(9, this.acfO);
      }
      if (this.acfP != null) {
        paramVarArgs.g(10, this.acfP);
      }
      if (this.acfQ != null) {
        paramVarArgs.g(11, this.acfQ);
      }
      AppMethodBeat.o(258080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label942;
      }
    }
    label942:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.acfK);
      paramInt = i;
      if (this.mut != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.mut);
      }
      i = paramInt;
      if (this.muu != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.muu);
      }
      paramInt = i;
      if (this.acfL != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.acfL);
      }
      i = paramInt;
      if (this.muw != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.muw);
      }
      paramInt = i;
      if (this.acfM != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.acfM);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.acfN);
      paramInt = i;
      if (this.acfO != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.acfO);
      }
      i = paramInt;
      if (this.acfP != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.acfP);
      }
      paramInt = i;
      if (this.acfQ != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.acfQ);
      }
      AppMethodBeat.o(258080);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.acfK.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258080);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gjt localgjt = (gjt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258080);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localgjt.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258080);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gjs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gjs)localObject2).parseFrom((byte[])localObject1);
            }
            localgjt.acfK.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258080);
          return 0;
        case 3: 
          localgjt.mut = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258080);
          return 0;
        case 4: 
          localgjt.muu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258080);
          return 0;
        case 5: 
          localgjt.acfL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258080);
          return 0;
        case 6: 
          localgjt.muw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258080);
          return 0;
        case 7: 
          localgjt.acfM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258080);
          return 0;
        case 8: 
          localgjt.acfN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258080);
          return 0;
        case 9: 
          localgjt.acfO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258080);
          return 0;
        case 10: 
          localgjt.acfP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258080);
          return 0;
        }
        localgjt.acfQ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258080);
        return 0;
      }
      AppMethodBeat.o(258080);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjt
 * JD-Core Version:    0.7.0.1
 */