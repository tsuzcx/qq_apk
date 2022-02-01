package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbf
  extends com.tencent.mm.cd.a
{
  public int SMR;
  public LinkedList<FinderObject> SMS;
  public String desc;
  public String key;
  public String kig;
  public long kik;
  public long liveId;
  public String nonceId;
  public String sessionBuffer;
  public FinderObject xcx;
  
  public bbf()
  {
    AppMethodBeat.i(231236);
    this.SMS = new LinkedList();
    AppMethodBeat.o(231236);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231239);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.f(1, this.key);
      }
      paramVarArgs.bm(2, this.liveId);
      if (this.nonceId != null) {
        paramVarArgs.f(3, this.nonceId);
      }
      paramVarArgs.bm(4, this.kik);
      if (this.kig != null) {
        paramVarArgs.f(5, this.kig);
      }
      if (this.desc != null) {
        paramVarArgs.f(6, this.desc);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.f(7, this.sessionBuffer);
      }
      if (this.xcx != null)
      {
        paramVarArgs.oE(8, this.xcx.computeSize());
        this.xcx.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.SMR);
      paramVarArgs.e(10, 8, this.SMS);
      AppMethodBeat.o(231239);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label850;
      }
    }
    label850:
    for (paramInt = g.a.a.b.b.a.g(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.liveId);
      paramInt = i;
      if (this.nonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.nonceId);
      }
      i = paramInt + g.a.a.b.b.a.p(4, this.kik);
      paramInt = i;
      if (this.kig != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.kig);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.desc);
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.sessionBuffer);
      }
      i = paramInt;
      if (this.xcx != null) {
        i = paramInt + g.a.a.a.oD(8, this.xcx.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(9, this.SMR);
      int j = g.a.a.a.c(10, 8, this.SMS);
      AppMethodBeat.o(231239);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SMS.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231239);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bbf localbbf = (bbf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        FinderObject localFinderObject;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231239);
          return -1;
        case 1: 
          localbbf.key = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231239);
          return 0;
        case 2: 
          localbbf.liveId = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(231239);
          return 0;
        case 3: 
          localbbf.nonceId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231239);
          return 0;
        case 4: 
          localbbf.kik = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(231239);
          return 0;
        case 5: 
          localbbf.kig = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231239);
          return 0;
        case 6: 
          localbbf.desc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231239);
          return 0;
        case 7: 
          localbbf.sessionBuffer = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231239);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localFinderObject = new FinderObject();
            if ((localObject != null) && (localObject.length > 0)) {
              localFinderObject.parseFrom((byte[])localObject);
            }
            localbbf.xcx = localFinderObject;
            paramInt += 1;
          }
          AppMethodBeat.o(231239);
          return 0;
        case 9: 
          localbbf.SMR = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(231239);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localFinderObject = new FinderObject();
          if ((localObject != null) && (localObject.length > 0)) {
            localFinderObject.parseFrom((byte[])localObject);
          }
          localbbf.SMS.add(localFinderObject);
          paramInt += 1;
        }
        AppMethodBeat.o(231239);
        return 0;
      }
      AppMethodBeat.o(231239);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbf
 * JD-Core Version:    0.7.0.1
 */