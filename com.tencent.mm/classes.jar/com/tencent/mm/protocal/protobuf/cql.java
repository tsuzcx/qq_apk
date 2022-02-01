package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cql
  extends erp
{
  public String QKl;
  public String aawX;
  public String aawY;
  public String aawZ;
  public String hQv;
  public String mdG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259054);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hQv != null) {
        paramVarArgs.g(2, this.hQv);
      }
      if (this.QKl != null) {
        paramVarArgs.g(3, this.QKl);
      }
      if (this.aawX != null) {
        paramVarArgs.g(4, this.aawX);
      }
      if (this.mdG != null) {
        paramVarArgs.g(5, this.mdG);
      }
      if (this.aawY != null) {
        paramVarArgs.g(6, this.aawY);
      }
      if (this.aawZ != null) {
        paramVarArgs.g(7, this.aawZ);
      }
      AppMethodBeat.o(259054);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label648;
      }
    }
    label648:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hQv != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hQv);
      }
      i = paramInt;
      if (this.QKl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.QKl);
      }
      paramInt = i;
      if (this.aawX != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aawX);
      }
      i = paramInt;
      if (this.mdG != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.mdG);
      }
      paramInt = i;
      if (this.aawY != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aawY);
      }
      i = paramInt;
      if (this.aawZ != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aawZ);
      }
      AppMethodBeat.o(259054);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259054);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cql localcql = (cql)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259054);
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
            localcql.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259054);
          return 0;
        case 2: 
          localcql.hQv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259054);
          return 0;
        case 3: 
          localcql.QKl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259054);
          return 0;
        case 4: 
          localcql.aawX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259054);
          return 0;
        case 5: 
          localcql.mdG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259054);
          return 0;
        case 6: 
          localcql.aawY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259054);
          return 0;
        }
        localcql.aawZ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259054);
        return 0;
      }
      AppMethodBeat.o(259054);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cql
 * JD-Core Version:    0.7.0.1
 */