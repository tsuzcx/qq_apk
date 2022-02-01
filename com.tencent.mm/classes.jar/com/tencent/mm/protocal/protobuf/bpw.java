package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bpw
  extends dyl
{
  public int Tbo;
  public String app_id;
  public int time_stamp;
  public String tnX;
  public b tqA;
  public int tyG;
  public String tyH;
  public String tyI;
  public String tyJ;
  public String tyK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114000);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.app_id != null) {
        paramVarArgs.f(2, this.app_id);
      }
      paramVarArgs.aY(3, this.tyG);
      if (this.tyH != null) {
        paramVarArgs.f(4, this.tyH);
      }
      if (this.tyI != null) {
        paramVarArgs.f(5, this.tyI);
      }
      paramVarArgs.aY(6, this.time_stamp);
      if (this.tyJ != null) {
        paramVarArgs.f(7, this.tyJ);
      }
      if (this.tnX != null) {
        paramVarArgs.f(8, this.tnX);
      }
      if (this.tyK != null) {
        paramVarArgs.f(9, this.tyK);
      }
      if (this.tqA != null) {
        paramVarArgs.c(10, this.tqA);
      }
      paramVarArgs.aY(11, this.Tbo);
      AppMethodBeat.o(114000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label852;
      }
    }
    label852:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.app_id != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.app_id);
      }
      i += g.a.a.b.b.a.bM(3, this.tyG);
      paramInt = i;
      if (this.tyH != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.tyH);
      }
      i = paramInt;
      if (this.tyI != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.tyI);
      }
      i += g.a.a.b.b.a.bM(6, this.time_stamp);
      paramInt = i;
      if (this.tyJ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.tyJ);
      }
      i = paramInt;
      if (this.tnX != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.tnX);
      }
      paramInt = i;
      if (this.tyK != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.tyK);
      }
      i = paramInt;
      if (this.tqA != null) {
        i = paramInt + g.a.a.b.b.a.b(10, this.tqA);
      }
      paramInt = g.a.a.b.b.a.bM(11, this.Tbo);
      AppMethodBeat.o(114000);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114000);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bpw localbpw = (bpw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114000);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localbpw.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(114000);
          return 0;
        case 2: 
          localbpw.app_id = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 3: 
          localbpw.tyG = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(114000);
          return 0;
        case 4: 
          localbpw.tyH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 5: 
          localbpw.tyI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 6: 
          localbpw.time_stamp = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(114000);
          return 0;
        case 7: 
          localbpw.tyJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 8: 
          localbpw.tnX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 9: 
          localbpw.tyK = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114000);
          return 0;
        case 10: 
          localbpw.tqA = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(114000);
          return 0;
        }
        localbpw.Tbo = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(114000);
        return 0;
      }
      AppMethodBeat.o(114000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpw
 * JD-Core Version:    0.7.0.1
 */