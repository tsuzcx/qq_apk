package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apr
  extends dyy
{
  public String SCY;
  public bkx SCZ;
  public int SDa;
  public bfm SDb;
  public LinkedList<String> SDc;
  public int SDd;
  public dhc SDe;
  public bhh SDf;
  public LinkedList<FinderObject> SDg;
  public String SDh;
  public FinderContact contact;
  public int continueFlag;
  public int fans_count;
  public int friend_follow_count;
  public com.tencent.mm.cd.b lastBuffer;
  public LinkedList<FinderObject> object;
  public int privateLock;
  
  public apr()
  {
    AppMethodBeat.i(207667);
    this.object = new LinkedList();
    this.SDc = new LinkedList();
    this.SDg = new LinkedList();
    AppMethodBeat.o(207667);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207675);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(207675);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.SCY != null) {
        paramVarArgs.f(3, this.SCY);
      }
      if (this.SCZ != null)
      {
        paramVarArgs.oE(4, this.SCZ.computeSize());
        this.SCZ.writeFields(paramVarArgs);
      }
      if (this.contact != null)
      {
        paramVarArgs.oE(5, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.SDa);
      paramVarArgs.aY(7, this.continueFlag);
      if (this.SDb != null)
      {
        paramVarArgs.oE(8, this.SDb.computeSize());
        this.SDb.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.fans_count);
      if (this.lastBuffer != null) {
        paramVarArgs.c(10, this.lastBuffer);
      }
      paramVarArgs.aY(11, this.friend_follow_count);
      paramVarArgs.e(12, 1, this.SDc);
      paramVarArgs.aY(13, this.SDd);
      if (this.SDe != null)
      {
        paramVarArgs.oE(14, this.SDe.computeSize());
        this.SDe.writeFields(paramVarArgs);
      }
      if (this.SDf != null)
      {
        paramVarArgs.oE(15, this.SDf.computeSize());
        this.SDf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.SDg);
      paramVarArgs.aY(17, this.privateLock);
      if (this.SDh != null) {
        paramVarArgs.f(18, this.SDh);
      }
      AppMethodBeat.o(207675);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1750;
      }
    }
    label1750:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.SCY != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SCY);
      }
      i = paramInt;
      if (this.SCZ != null) {
        i = paramInt + g.a.a.a.oD(4, this.SCZ.computeSize());
      }
      paramInt = i;
      if (this.contact != null) {
        paramInt = i + g.a.a.a.oD(5, this.contact.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.SDa) + g.a.a.b.b.a.bM(7, this.continueFlag);
      paramInt = i;
      if (this.SDb != null) {
        paramInt = i + g.a.a.a.oD(8, this.SDb.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.fans_count);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(10, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.friend_follow_count) + g.a.a.a.c(12, 1, this.SDc) + g.a.a.b.b.a.bM(13, this.SDd);
      paramInt = i;
      if (this.SDe != null) {
        paramInt = i + g.a.a.a.oD(14, this.SDe.computeSize());
      }
      i = paramInt;
      if (this.SDf != null) {
        i = paramInt + g.a.a.a.oD(15, this.SDf.computeSize());
      }
      i = i + g.a.a.a.c(16, 8, this.SDg) + g.a.a.b.b.a.bM(17, this.privateLock);
      paramInt = i;
      if (this.SDh != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.SDh);
      }
      AppMethodBeat.o(207675);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.SDc.clear();
        this.SDg.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(207675);
          throw paramVarArgs;
        }
        AppMethodBeat.o(207675);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        apr localapr = (apr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207675);
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
            localapr.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207675);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localapr.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207675);
          return 0;
        case 3: 
          localapr.SCY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(207675);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkx)localObject2).parseFrom((byte[])localObject1);
            }
            localapr.SCZ = ((bkx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207675);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localapr.contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207675);
          return 0;
        case 6: 
          localapr.SDa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(207675);
          return 0;
        case 7: 
          localapr.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(207675);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfm)localObject2).parseFrom((byte[])localObject1);
            }
            localapr.SDb = ((bfm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207675);
          return 0;
        case 9: 
          localapr.fans_count = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(207675);
          return 0;
        case 10: 
          localapr.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(207675);
          return 0;
        case 11: 
          localapr.friend_follow_count = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(207675);
          return 0;
        case 12: 
          localapr.SDc.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(207675);
          return 0;
        case 13: 
          localapr.SDd = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(207675);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhc)localObject2).parseFrom((byte[])localObject1);
            }
            localapr.SDe = ((dhc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207675);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bhh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bhh)localObject2).parseFrom((byte[])localObject1);
            }
            localapr.SDf = ((bhh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207675);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localapr.SDg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207675);
          return 0;
        case 17: 
          localapr.privateLock = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(207675);
          return 0;
        }
        localapr.SDh = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(207675);
        return 0;
      }
      AppMethodBeat.o(207675);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apr
 * JD-Core Version:    0.7.0.1
 */