package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bx.a
{
  public b FNV;
  public String NPA;
  public int NPB;
  public e NPC;
  public b NPD;
  public String NPw;
  public String NPx;
  public String NPy;
  public String NPz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91744);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.NPw != null) {
        paramVarArgs.d(1, this.NPw);
      }
      if (this.NPx != null) {
        paramVarArgs.d(2, this.NPx);
      }
      if (this.NPy != null) {
        paramVarArgs.d(3, this.NPy);
      }
      if (this.NPz != null) {
        paramVarArgs.d(4, this.NPz);
      }
      if (this.NPA != null) {
        paramVarArgs.d(5, this.NPA);
      }
      paramVarArgs.aS(6, this.NPB);
      if (this.NPC != null)
      {
        paramVarArgs.lC(7, this.NPC.computeSize());
        this.NPC.writeFields(paramVarArgs);
      }
      if (this.NPD != null) {
        paramVarArgs.c(8, this.NPD);
      }
      if (this.FNV != null) {
        paramVarArgs.c(9, this.FNV);
      }
      AppMethodBeat.o(91744);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NPw == null) {
        break label782;
      }
    }
    label782:
    for (int i = f.a.a.b.b.a.e(1, this.NPw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NPx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.NPx);
      }
      i = paramInt;
      if (this.NPy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.NPy);
      }
      paramInt = i;
      if (this.NPz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.NPz);
      }
      i = paramInt;
      if (this.NPA != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.NPA);
      }
      i += f.a.a.b.b.a.bz(6, this.NPB);
      paramInt = i;
      if (this.NPC != null) {
        paramInt = i + f.a.a.a.lB(7, this.NPC.computeSize());
      }
      i = paramInt;
      if (this.NPD != null) {
        i = paramInt + f.a.a.b.b.a.b(8, this.NPD);
      }
      paramInt = i;
      if (this.FNV != null) {
        paramInt = i + f.a.a.b.b.a.b(9, this.FNV);
      }
      AppMethodBeat.o(91744);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91744);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91744);
          return -1;
        case 1: 
          localf.NPw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 2: 
          localf.NPx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 3: 
          localf.NPy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 4: 
          localf.NPz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 5: 
          localf.NPA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 6: 
          localf.NPB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91744);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.NPC = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91744);
          return 0;
        case 8: 
          localf.NPD = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(91744);
          return 0;
        }
        localf.FNV = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(91744);
        return 0;
      }
      AppMethodBeat.o(91744);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.f
 * JD-Core Version:    0.7.0.1
 */