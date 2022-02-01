package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class yr
  extends esc
{
  public String OhN;
  public String ZgF;
  public int ZgG;
  public LinkedList<Integer> ZgH;
  public int ZgK;
  public String desc;
  public int hAV;
  public String wYI;
  
  public yr()
  {
    AppMethodBeat.i(72446);
    this.ZgH = new LinkedList();
    AppMethodBeat.o(72446);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72447);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72447);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      if (this.OhN != null) {
        paramVarArgs.g(4, this.OhN);
      }
      if (this.ZgF != null) {
        paramVarArgs.g(5, this.ZgF);
      }
      paramVarArgs.bS(6, this.ZgG);
      paramVarArgs.e(7, 2, this.ZgH);
      if (this.desc != null) {
        paramVarArgs.g(8, this.desc);
      }
      paramVarArgs.bS(9, this.ZgK);
      AppMethodBeat.o(72447);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.OhN != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.OhN);
      }
      paramInt = i;
      if (this.ZgF != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZgF);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.ZgG) + i.a.a.a.c(7, 2, this.ZgH);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.desc);
      }
      i = i.a.a.b.b.a.cJ(9, this.ZgK);
      AppMethodBeat.o(72447);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZgH.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72447);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72447);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        yr localyr = (yr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72447);
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
            localyr.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(72447);
          return 0;
        case 2: 
          localyr.hAV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72447);
          return 0;
        case 3: 
          localyr.wYI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 4: 
          localyr.OhN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 5: 
          localyr.ZgF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 6: 
          localyr.ZgG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72447);
          return 0;
        case 7: 
          localyr.ZgH.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
          AppMethodBeat.o(72447);
          return 0;
        case 8: 
          localyr.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72447);
          return 0;
        }
        localyr.ZgK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(72447);
        return 0;
      }
      AppMethodBeat.o(72447);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yr
 * JD-Core Version:    0.7.0.1
 */