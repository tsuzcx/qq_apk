package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ecg
  extends com.tencent.mm.cd.a
{
  public String SjI;
  public String SjJ;
  public String Sqa;
  public String Sqb;
  public String Tav;
  public dfh UgX;
  public int Ugt;
  public String UserName;
  public String lVG;
  public int mVy;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152685);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      if (this.rWI != null) {
        paramVarArgs.f(2, this.rWI);
      }
      if (this.Sqa != null) {
        paramVarArgs.f(3, this.Sqa);
      }
      if (this.Sqb != null) {
        paramVarArgs.f(4, this.Sqb);
      }
      paramVarArgs.aY(5, this.mVy);
      if (this.SjI != null) {
        paramVarArgs.f(6, this.SjI);
      }
      if (this.SjJ != null) {
        paramVarArgs.f(7, this.SjJ);
      }
      if (this.lVG != null) {
        paramVarArgs.f(8, this.lVG);
      }
      paramVarArgs.aY(9, this.Ugt);
      if (this.UgX != null)
      {
        paramVarArgs.oE(10, this.UgX.computeSize());
        this.UgX.writeFields(paramVarArgs);
      }
      if (this.Tav != null) {
        paramVarArgs.f(11, this.Tav);
      }
      AppMethodBeat.o(152685);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label868;
      }
    }
    label868:
    for (int i = g.a.a.b.b.a.g(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.rWI);
      }
      i = paramInt;
      if (this.Sqa != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sqa);
      }
      paramInt = i;
      if (this.Sqb != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Sqb);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.mVy);
      paramInt = i;
      if (this.SjI != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SjI);
      }
      i = paramInt;
      if (this.SjJ != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SjJ);
      }
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.lVG);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.Ugt);
      paramInt = i;
      if (this.UgX != null) {
        paramInt = i + g.a.a.a.oD(10, this.UgX.computeSize());
      }
      i = paramInt;
      if (this.Tav != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.Tav);
      }
      AppMethodBeat.o(152685);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152685);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ecg localecg = (ecg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152685);
          return -1;
        case 1: 
          localecg.UserName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 2: 
          localecg.rWI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 3: 
          localecg.Sqa = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 4: 
          localecg.Sqb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 5: 
          localecg.mVy = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152685);
          return 0;
        case 6: 
          localecg.SjI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 7: 
          localecg.SjJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 8: 
          localecg.lVG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 9: 
          localecg.Ugt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152685);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dfh localdfh = new dfh();
            if ((localObject != null) && (localObject.length > 0)) {
              localdfh.parseFrom((byte[])localObject);
            }
            localecg.UgX = localdfh;
            paramInt += 1;
          }
          AppMethodBeat.o(152685);
          return 0;
        }
        localecg.Tav = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152685);
        return 0;
      }
      AppMethodBeat.o(152685);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecg
 * JD-Core Version:    0.7.0.1
 */