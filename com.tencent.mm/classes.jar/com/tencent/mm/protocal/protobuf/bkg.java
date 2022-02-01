package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkg
  extends com.tencent.mm.bx.a
{
  public FinderObject ABJ;
  public int ZTt;
  public LinkedList<FinderObject> ZTu;
  public String desc;
  public String key;
  public long liveId;
  public String mIC;
  public long mIH;
  public String nonceId;
  public String sessionBuffer;
  
  public bkg()
  {
    AppMethodBeat.i(259620);
    this.ZTu = new LinkedList();
    AppMethodBeat.o(259620);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259622);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.g(1, this.key);
      }
      paramVarArgs.bv(2, this.liveId);
      if (this.nonceId != null) {
        paramVarArgs.g(3, this.nonceId);
      }
      paramVarArgs.bv(4, this.mIH);
      if (this.mIC != null) {
        paramVarArgs.g(5, this.mIC);
      }
      if (this.desc != null) {
        paramVarArgs.g(6, this.desc);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.g(7, this.sessionBuffer);
      }
      if (this.ABJ != null)
      {
        paramVarArgs.qD(8, this.ABJ.computeSize());
        this.ABJ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(9, this.ZTt);
      paramVarArgs.e(10, 8, this.ZTu);
      AppMethodBeat.o(259622);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label850;
      }
    }
    label850:
    for (paramInt = i.a.a.b.b.a.h(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.liveId);
      paramInt = i;
      if (this.nonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.nonceId);
      }
      i = paramInt + i.a.a.b.b.a.q(4, this.mIH);
      paramInt = i;
      if (this.mIC != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.mIC);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.desc);
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.sessionBuffer);
      }
      i = paramInt;
      if (this.ABJ != null) {
        i = paramInt + i.a.a.a.qC(8, this.ABJ.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(9, this.ZTt);
      int j = i.a.a.a.c(10, 8, this.ZTu);
      AppMethodBeat.o(259622);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZTu.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259622);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bkg localbkg = (bkg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        FinderObject localFinderObject;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259622);
          return -1;
        case 1: 
          localbkg.key = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259622);
          return 0;
        case 2: 
          localbkg.liveId = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259622);
          return 0;
        case 3: 
          localbkg.nonceId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259622);
          return 0;
        case 4: 
          localbkg.mIH = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259622);
          return 0;
        case 5: 
          localbkg.mIC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259622);
          return 0;
        case 6: 
          localbkg.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259622);
          return 0;
        case 7: 
          localbkg.sessionBuffer = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259622);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localFinderObject = new FinderObject();
            if ((localObject != null) && (localObject.length > 0)) {
              localFinderObject.parseFrom((byte[])localObject);
            }
            localbkg.ABJ = localFinderObject;
            paramInt += 1;
          }
          AppMethodBeat.o(259622);
          return 0;
        case 9: 
          localbkg.ZTt = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259622);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localFinderObject = new FinderObject();
          if ((localObject != null) && (localObject.length > 0)) {
            localFinderObject.parseFrom((byte[])localObject);
          }
          localbkg.ZTu.add(localFinderObject);
          paramInt += 1;
        }
        AppMethodBeat.o(259622);
        return 0;
      }
      AppMethodBeat.o(259622);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkg
 * JD-Core Version:    0.7.0.1
 */